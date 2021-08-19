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
import android.widget.Toast;

import com.example.movers_app.models.MovingOrders;
import com.example.movers_app.network.MoversAPI;
import com.example.movers_app.network.MoversClient;

import java.time.Year;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PickupsActivity extends AppCompatActivity {
     Button btndate,btntime,costbtn;
     TextView text_date,text_time;

    int cyear,cmonth,cday;
    int chour,cminute;

    String [] orderInfo;

    String date;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickups);


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
                     date = dayOfMonth+"/"+(month+1) +"/"+year;
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
                        text_time.setText(hourOfDay+":"+minute);

                        time = hourOfDay+":"+minute;
                        Log.i("time",time);

                        Bundle extras = getIntent().getExtras();
                        orderInfo = extras.getStringArray("orderInfo");

                        String pickup_time = date+" "+ time+" ";

                        Log.i("message",orderInfo[0]+""+orderInfo[1]+""+orderInfo[2]);
                        saveOrder(orderInfo[0],orderInfo[1],orderInfo[2],orderInfo[3],orderInfo[4],orderInfo[5],79898,"approved",pickup_time);

                    }
                },chour,cminute,false);
                timePickerDialog.show();



            }


        });

    }

    public void saveOrder(String user_name, String user_email, String inventory, String current_location, String new_location, String moving_company, int total_price, String order_status, String pickup_time){

        MovingOrders movingOrder = new MovingOrders(user_name,user_email,inventory,current_location,new_location,moving_company,total_price,order_status,pickup_time);
        MoversAPI client = MoversClient.getClient();
        Call<MovingOrders> call = client.postMovingOrder(movingOrder);
        call.enqueue(new Callback<MovingOrders>() {
            @Override
            public void onResponse(Call<MovingOrders> call, Response<MovingOrders> response) {
                Toast.makeText(getApplicationContext(),"Moving Order Successful",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MovingOrdersActivity.class);
                intent.putExtra("username",user_name);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<MovingOrders> call, Throwable t) {

               Log.i("api",t.getMessage());
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();

            }
        });

    }
}