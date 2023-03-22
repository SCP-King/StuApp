package com.example.stu_app.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stu_app.R;
import com.example.stu_app.pojo.Days;
import com.example.stu_app.pojo.Summary;

import java.util.List;

public class SummaryAdapter extends BaseAdapter {
    private Context context;
    private List<Summary> summaries;

    public SummaryAdapter(Context context, List<Summary> summaries) {
        this.context = context;
        this.summaries = summaries;
    }

    @Override
    public int getCount() {
        return summaries.size();
    }

    @Override
    public Object getItem(int position) {
        return summaries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_onesummary,null);
        Summary summary=summaries.get(position);
        TextView textView=null;
        textView=view.findViewById(R.id.stuid);
        textView.setText(String.valueOf(summary.getStuid()));
        textView=view.findViewById(R.id.keywords);
        textView.setText(summary.getStukeywords());
        textView=view.findViewById(R.id.date);
        textView.setText(summary.getStudate());
        return  view;
    }
}
