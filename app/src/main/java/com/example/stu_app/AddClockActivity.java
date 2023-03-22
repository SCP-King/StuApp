package com.example.stu_app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stu_app.pojo.Event;

import java.util.Calendar;


@SuppressLint("MissingInflatedId")
public class AddClockActivity extends AppCompatActivity implements View.OnClickListener {
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private  TimePicker timePicker;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuclock);
        timePicker=findViewById(R.id.stuclock);
        timePicker.setIs24HourView(true);
        findViewById(R.id.addclock).setOnClickListener(this);
        alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    @Override
    public void onClick(View v) {
        EditText editText=findViewById(R.id.event);
        String s=editText.getText().toString();
        Calendar calendar=Calendar.getInstance();
       int hour=timePicker.getHour();
       int minute=timePicker.getMinute();
       calendar.set(Calendar.HOUR,hour);
       calendar.set(Calendar.MINUTE,minute);
        System.out.println(calendar.getTimeInMillis());
        Intent intent=new Intent(AddClockActivity.this,RemainActivity.class);
        Event.event=s;
        System.out.println(System.currentTimeMillis());
        pendingIntent=PendingIntent.getActivity(AddClockActivity.this,0,intent, PendingIntent.FLAG_MUTABLE);
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
    }
}
