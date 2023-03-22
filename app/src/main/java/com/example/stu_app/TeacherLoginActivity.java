package com.example.stu_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stu_app.utils.SqlUtils;

public class TeacherLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherlogin);
        findViewById(R.id.teacherlogin).setOnClickListener(this);
        findViewById(R.id.teacherresiger).setOnClickListener(this);
        preferences=getSharedPreferences("teacher", Context.MODE_PRIVATE);
        int id=preferences.getInt("id",0);
        if(id!=0){
            EditText e=findViewById(R.id.id);
            e.setText(String.valueOf(id));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.teacherlogin:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                EditText e=findViewById(R.id.id);
                int id=Integer.parseInt(e.getText().toString());
                e=findViewById(R.id.password);
                int pwd=Integer.parseInt(e.getText().toString());
                SharedPreferences.Editor editor=preferences.edit();
                editor.putInt("id",id);
                editor.commit();
                builder.setTitle("登录结果");
                if(SqlUtils.teacherlogin(id,pwd)){
                    builder.setMessage("登录成功")
                            .setPositiveButton("确定", (dialog, which) -> {
                                startActivity(new Intent(TeacherLoginActivity.this,TeacherActivity.class));
                            });
                }
                else {
                    builder.setMessage("登录失败")
                            .setPositiveButton("确定",null);
                }
                builder.show();
                break;
            case R.id.teacherresiger:
                startActivity(new Intent(TeacherLoginActivity.this,AddTeacherActivity.class));
                break;
        }
    }
}
