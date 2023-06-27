package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bai2 extends AppCompatActivity implements View.OnClickListener {
    private Button btnLoad;
    private ImageView imgLoad;
    private ProgressDialog progressDialog;
    private String url = "https://vapa.vn/wp-content/uploads/2022/12/anh-3d-thien-nhien.jpeg";
    private Bitmap bitmap = null;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        imgLoad = findViewById(R.id.imgView);
        btnLoad = findViewById(R.id.btnLoad);
        tvMessage = findViewById(R.id.tvMess);
        btnLoad.setOnClickListener(this);
    }

    private Handler messageHandler = new Handler(){
        public void handlerMessage(Message msg){
            Bundle bundle = msg.getData();
            String message = bundle.getString("message");
            tvMessage.setText(message);
            imgLoad.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };

    @Override
    public void onClick(View view) {
        progressDialog = ProgressDialog.show(Bai2.this,"","Dowloading...");
        Runnable aRunnable = new Runnable() {
            @Override
            public void run() {
                bitmap = downloadBitmap(url);
                Message msg = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String threadMessage = "Image downloaded";
                bundle.putString("message",threadMessage);
                msg.setData(bundle);
                messageHandler.sendMessage(msg);
            }
        };
    }
    private Bitmap downloadBitmap(String link){
        try{
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}