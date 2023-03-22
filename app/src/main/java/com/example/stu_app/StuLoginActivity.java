package com.example.stu_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stu_app.utils.SqlUtils;

@SuppressLint("MissingInflatedId")
public class StuLoginActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stulogin);
        findViewById(R.id.stulogin).setOnClickListener(this);
        findViewById(R.id.sturesiger).setOnClickListener(this);
        sharedPreferences=getSharedPreferences("Stu", Context.MODE_PRIVATE);
        int id=sharedPreferences.getInt("id",0);
        if(id!=0){
            EditText e=findViewById(R.id.id);
            e.setText(String.valueOf(id));
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.stulogin:
                EditText e=findViewById(R.id.id);
                int id=Integer.parseInt(e.getText().toString());
                e=findViewById(R.id.password);
                int pwd=Integer.parseInt(e.getText().toString());
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("id",id);
                editor.commit();
                builder.setTitle("登录结果");
                if(SqlUtils.stulogin(id,pwd)){
                    builder.setMessage("登录成功")
                            .setPositiveButton("确定", (dialog, which) -> {
                                startActivity(new Intent(StuLoginActivity.this,StuActivity.class));
                            });
                }
                else {
                    builder.setMessage("登录失败")
                            .setPositiveButton("确定",null);
                }
                builder.show();
                break;
            case R.id.sturesiger:
                startActivity(new Intent(StuLoginActivity.this,AddStuActivity.class));
                break;
        }
    }
}
