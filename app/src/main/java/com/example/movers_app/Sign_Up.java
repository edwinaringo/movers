package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_Up extends AppCompatActivity {

    private TextView hi;
    private TextView req;
    private TextView TextView2;
    private TextView TextView3;
    private TextView TextView4;
    private TextView TextView5;
    private TextView TextView6;
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private Button button;
    private Button button2;


    boolean isValid = false;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        hi = findViewById(R.id.hi);
        req = findViewById(R.id.req);
        TextView2 = findViewById(R.id.textView2);
        TextView3 = findViewById(R.id.textView3);
        TextView4 = findViewById(R.id.textView4);
        TextView5 = findViewById(R.id.textView5);
        TextView6 = findViewById(R.id.textView6);
        editText = findViewById(R.id.editTextPersonN);
        editText2 = findViewById(R.id.editTextEmail);
        editText3 = findViewById(R.id.editTextpassword);
        editText4 = findViewById(R.id.editTextpassconfm);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public int hashCode() {
//                return super.hashCode();
//            }

            @Override
            public void onClick(View v) {
//                String inputText1 = hi .getText().toString();
//                String inputText2 = req .getText().toString();
                String inputText3 = TextView2.getText().toString();
                String inputText4 = TextView3.getText().toString();
                String inputText5 = TextView4.getText().toString();
                String inputText6 = TextView5.getText().toString();
                String inputEditText = editText.getText().toString();
                String inputEditText2 = editText2.getText().toString();
                String inputEditText3 = editText3.getText().toString();
                String inputEditText4 = editText4.getText().toString();

                isValid = validate(inputText3.isEmpty(),
                        inputText4.isEmpty(),
                        inputText5.isEmpty(),
                        inputText6.isEmpty(),
                        inputEditText.isEmpty(),
                        inputEditText2.isEmpty(), inputEditText3.isEmpty(), inputEditText4.isEmpty());
                {



                    Toast.makeText(Sign_Up.this, "Login was successful", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validate(boolean empty, boolean empty1, boolean empty2, boolean empty3, boolean empty4, boolean empty5, boolean empty6, boolean empty7) {
        if (button.equals(TextView3)) {


            return true;
        }
        return false;
    }
}




