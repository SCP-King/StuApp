package com.example.stu_app;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stu_app.pojo.Days;
import com.example.stu_app.pojo.Summary;
import com.example.stu_app.utils.RefreshDays;
import com.example.stu_app.utils.SqlUtils;

import java.time.LocalDate;
@SuppressLint("MissingInflatedId")
public class AddSummaryActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stusummary);
        Button button=findViewById(R.id.addsummary);
        button.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        EditText editText=findViewById(R.id.stuid);
        int id=Integer.parseInt(editText.getText().toString());
        editText=findViewById(R.id.keywords);
        String keywords=editText.getText().toString();
        editText=findViewById(R.id.summary);
        String summary=editText.getText().toString();
        LocalDate date=LocalDate.now();
        System.out.println(date);
        Summary summary0=new Summary(id,keywords,summary,date.toString());
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("打卡结果");
        if(SqlUtils.addsummary(summary0)){
            RefreshDays.refresh(id);
            Days days= SqlUtils.selectdays(id);
            builder.setTitle("打卡成功\n"+"已经打卡天数: "+days.getStudays()+"最长坚持天数: "+days.getStulongdays());
        }
        else{
            builder.setTitle("打卡失败");
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
