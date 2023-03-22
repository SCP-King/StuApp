package com.example.stu_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stu_app.pojo.Teacher;
import com.example.stu_app.utils.SqlUtils;

public class AddTeacherActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherresiger);
        preferences=getSharedPreferences("Teacher", Context.MODE_PRIVATE);
        int id=preferences.getInt("id",0);
        if(id!=0){
            EditText e=findViewById(R.id.teacherid);
            e.setText(String.valueOf(id));
        }
        findViewById(R.id.resiger).setOnClickListener(this);
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onClick(View v) {
        EditText e=null;
        e=findViewById(R.id.teacherid);
        int id=Integer.parseInt(e.getText().toString());
        e=findViewById(R.id.teacherpassword);
        int pwd=Integer.parseInt(e.getText().toString());
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("id",id);
        editor.commit();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("注册结果");
        if(SqlUtils.addteacher(new Teacher(id,pwd))){
            builder.setMessage("注册成功");
        }
        else {
            builder.setMessage("注册失败");
        }
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }
}
