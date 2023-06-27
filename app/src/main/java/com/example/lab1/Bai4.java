package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4 extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button btnRun;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        editText = findViewById(R.id.edText);
        btnRun = findViewById(R.id.btnRun);
        tvResult = findViewById(R.id.tvResult);
        btnRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(tvResult, editText, this);
        String sleepTime = editText.getText().toString();
        asyncTaskRunner.execute(sleepTime);
    }
}