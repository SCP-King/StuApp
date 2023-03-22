package com.example.stu_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stu_app.pojo.Stu;
import com.example.stu_app.utils.SqlUtils;

@SuppressLint("MissingInflatedId")
public class AddStuActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sturesiger);
         Button button=findViewById(R.id.resiger);
         button.setOnClickListener(this);
         preferences=getSharedPreferences("Name", Context.MODE_PRIVATE);
         String Name=preferences.getString("name",null);
         if(Name!=null){
             EditText editText=findViewById(R.id.stuname);
             editText.setText(Name);
         }
    }

    @Override
    public void onClick(View v) {
        EditText editText=findViewById(R.id.stuid);
        int id=Integer.parseInt(editText.getText().toString());
        editText=findViewById(R.id.stuname);
        String name=editText.getText().toString();
        editText=findViewById(R.id.stuphone);
        String phone=editText.getText().toString();
        editText=findViewById(R.id.stuclass);
        String stuclass=editText.getText().toString();
        editText=findViewById(R.id.stupassword);
        int password=Integer.parseInt(editText.getText().toString());
        Stu stu=new Stu(id,name,phone,stuclass,password);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("name",name);
        editor.commit();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("注册结果");
        if(SqlUtils.addstu(stu)){
            builder.setMessage("注册成功");
        }
        else{
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
