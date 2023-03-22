package com.example.stu_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stu_app.pojo.Event;

@SuppressLint("MissingInflatedId")
public class RemainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remain);
        findViewById(R.id.close).setOnClickListener(this);
         TextView textView=findViewById(R.id.reamin);
        Intent intent=getIntent();
        textView.setText(Event.event);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
