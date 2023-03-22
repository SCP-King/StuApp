package com.example.stu_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StuActivity extends AppCompatActivity implements View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
      Button button=findViewById(R.id.addsummary);
        button.setOnClickListener(this);
        button=findViewById(R.id.addclock);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addsummary:
                startActivity(new Intent(StuActivity.this,AddSummaryActivity.class));
                break;
            case R.id.addclock:
                startActivity(new Intent(StuActivity.this,AddClockActivity.class));
                break;
        }
    }
}
