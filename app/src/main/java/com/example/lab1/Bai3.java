package com.example.lab1;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class Bai3 extends AppCompatActivity implements View.OnClickListener,Listener {
    private Button btnLoad;
    private ImageView imgAndroid;
    private TextView tvMessage;

    public static final String IMAGE_URL = "https://vapa.vn/wp-content/uploads/2022/12/anh-3d-thien-nhien.jpeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        btnLoad = findViewById(R.id.btnLoad);
        imgAndroid = findViewById(R.id.imgView);
        tvMessage = findViewById(R.id.tvMess);

        btnLoad.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        new LoadImageTask(this,this).execute(IMAGE_URL);
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imgAndroid.setImageBitmap(bitmap);
        tvMessage.setText("Image Downloaded");
    }

    @Override
    public void onError() {
        tvMessage.setText("Error download image");
    }
}