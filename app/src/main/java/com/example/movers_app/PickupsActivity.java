package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.Year;
import java.util.Calendar;

public class PickupsActivity extends AppCompatActivity {
     Button btndate,btntime;
     TextView text_date,text_time;

    int cyear,cmonth,cday;
    int chour,cminute;

//    String inventory ;
//    String source;
//    String destination;
    String [] orderInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickups);



        Bundle extras = getIntent().getExtras();
        orderInfo = extras.getStringArray("orderInfo");

        Log.i("message",orderInfo[0]+""+orderInfo[1]+""+orderInfo[2]);


        btndate = (Button)findViewById(R.id.btn_date);
        btntime = (Button)findViewById(R.id.btn_time);

        text_date = (TextView)findViewById(R.id.date_textview);
        text_time = (TextView)findViewById(R.id.time_textview);

        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar calendar = Calendar.getInstance();
                cyear= calendar.get(Calendar.YEAR);
                cmonth = calendar.get(Calendar.MONTH);
                cday = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(PickupsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                     text_date.setText(dayOfMonth+"/"+(month+1) +"/"+year);
                    }
                },cyear,cmonth,cday);
                datePickerDialog.show();

            }
        });

        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final Calendar calendar= Calendar.getInstance();
               chour = calendar.get(Calendar.HOUR_OF_DAY);
               cminute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(PickupsActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        text_date.setText(hourOfDay+":"+minute);
                    }
                },chour,cminute,false);
                timePickerDialog.show();
            }
        });

    }
}