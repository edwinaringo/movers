package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OffersActivity extends AppCompatActivity {
    EditText n1;
    EditText n2;
    TextView tv;
    Button  mul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        n1 = (EditText) findViewById(R.id.editText);
        n2 = (EditText) findViewById(R.id.editText2);
        tv = (TextView) findViewById(R.id.textView);
        mul = (Button) findViewById(R.id.button3);






        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer no1 = Integer.parseInt(n1.getText().toString());
                Integer no2 = Integer.parseInt(n2.getText().toString());

                Integer multiply = no1 * no2;
                tv.setText(multiply.toString());



            }
        });
    }
}
