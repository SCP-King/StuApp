package com.example.stu_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.stu);
        button.setOnClickListener(this);
        button=findViewById(R.id.teacher);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.stu:
                startActivity(new Intent(MainActivity.this,StuLoginActivity.class));
                break;
            case R.id.teacher:
                startActivity(new Intent(MainActivity.this,TeacherLoginActivity.class));
                break;
        }
    }
}