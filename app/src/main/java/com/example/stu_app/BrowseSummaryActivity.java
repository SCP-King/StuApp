package com.example.stu_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stu_app.pojo.Summary;
import com.example.stu_app.utils.SqlUtils;
import com.example.stu_app.utils.SummaryAdapter;

import java.util.List;

@SuppressLint("MissingInflatedId")
public class BrowseSummaryActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsesummary);
        findViewById(R.id.find).setOnClickListener(this);
        List<Summary> summaryList=SqlUtils.browsesummary(0,null,null);
         if(summaryList!=null) {
             SummaryAdapter summaryAdapter = new SummaryAdapter(getApplicationContext(), summaryList);
             ListView listView = findViewById(R.id.browse);
             listView.setAdapter(summaryAdapter);
         }
    }

    @Override
    public void onClick(View v) {
        EditText editText=null;
        int id=0;
        editText=findViewById(R.id.id);
        if(!editText.getText().toString().equals(""))
        id=Integer.parseInt(editText.getText().toString());
        editText=findViewById(R.id.keywords);
        String keywords=editText.getText().toString();
        editText=findViewById(R.id.date);
        String date=editText.getText().toString();
        List<Summary> summaryList=SqlUtils.browsesummary(id,keywords,date);
        if(summaryList!=null) {
            SummaryAdapter summaryAdapter = new SummaryAdapter(getApplicationContext(), summaryList);
            ListView listView = findViewById(R.id.browse);
            listView.setAdapter(summaryAdapter);
        }


    }
}
