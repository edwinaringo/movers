package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Movers extends AppCompatActivity {

    private EditText mCompanyName,mStudioPrice, mOneBedroomPrice, mTwoBedroomPrice, mThreeBedroomPrice;
    private Button submitPrices;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("MoverPrices");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movers);

        mCompanyName = findViewById(R.id.companyName);
        mStudioPrice = findViewById(R.id.studioPrice);
        mOneBedroomPrice = findViewById(R.id.oneBedRoomPrice);
        mTwoBedroomPrice = findViewById(R.id.twoBedRoomPrice);
        mThreeBedroomPrice = findViewById(R.id.threeBedRoomPrice);

        submitPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String companyName = mCompanyName.getText().toString();
                String studioPrice = mStudioPrice.getText().toString();
                String oneBedroomPrice = mOneBedroomPrice.getText().toString();
                String twoBedroomPrice = mTwoBedroomPrice.getText().toString();
                String threeBedroomPrice = mThreeBedroomPrice.getText().toString();

                HashMap<String, String> pricesMap = new HashMap<>();

                pricesMap.put("Company Name", companyName);
                pricesMap.put("Studio Price", studioPrice);
                pricesMap.put("One Bedroom Price", oneBedroomPrice);
                pricesMap.put("Two Bedroom Price", twoBedroomPrice);
                pricesMap.put("Three Bedroom Price", threeBedroomPrice);
            }
        });
    }
}