package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class Bai1 extends AppCompatActivity implements View.OnClickListener {
    private Button btnLoad;
    private ImageView imgAndroid;
    private TextView tvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        btnLoad = findViewById(R.id.btnLoad);
        imgAndroid = findViewById(R.id.imgView);
        tvMessage = findViewById(R.id.tvNoti);

        btnLoad.setOnClickListener(this);
    }

    private Bitmap loadImageFromNetWork(String link){
        URL url;
        Bitmap bmp = null;
        try{
            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
        return bmp;
    }

    @Override
    public void onClick(View view) {
        final Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImageFromNetWork("https://vapa.vn/wp-content/uploads/2022/12/anh-3d-thien-nhien.jpeg");
                imgAndroid.post(new Runnable() {
                    @Override
                    public void run() {
                        tvMessage.setText("Image Dowloaded");
                        imgAndroid.setImageBitmap(bitmap);
                    }
                });
            }
        });
        myThread.start();
    }
}