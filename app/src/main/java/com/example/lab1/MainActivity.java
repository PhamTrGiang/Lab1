package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bai1(View view){
        Intent i = new Intent(getBaseContext(),Bai1.class);
        startActivity(i);
    }
    public void bai2(View view){
        Intent i = new Intent(getBaseContext(), SplashScreen.class);
        startActivity(i);
    }
    public void bai3(View view){
        Intent i = new Intent(getBaseContext(),Bai3.class);
        startActivity(i);
    }
    public void bai4(View view){
        Intent i = new Intent(getBaseContext(),Bai4.class);
        startActivity(i);
    }

}