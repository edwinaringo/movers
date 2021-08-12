package com.example.movers_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Movers extends AppCompatActivity {

    private EditText mCompanyName,mContactInfo, mExtraServices, mInventoryCharges, mDistanceCharges;
    private Button submitPrices;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("MoverPrices");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movers);

        mCompanyName = findViewById(R.id.companyName);
        mContactInfo = findViewById(R.id.contactInfo);
        mExtraServices = findViewById(R.id.extraServices);
        mInventoryCharges = findViewById(R.id.inventoryCharges);
        mDistanceCharges = findViewById(R.id.distanceCharges);
        submitPrices = findViewById(R.id.submitPrices);

        submitPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String companyName = mCompanyName.getText().toString();
                String contactInfo = mContactInfo.getText().toString();
                String extraServices = mExtraServices.getText().toString();
                String inventoryCharges = mInventoryCharges.getText().toString();
                String distanceCharges = mDistanceCharges.getText().toString();

                HashMap<String, Object> pricesMap = new HashMap<>();

                pricesMap.put("Company Name", companyName);
                pricesMap.put("contact info", contactInfo);
                pricesMap.put("extra service", extraServices);
                pricesMap.put("inventory", inventoryCharges);
                pricesMap.put("price per distance", distanceCharges);

                root.updateChildren(pricesMap)

//                root.setValue(pricesMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(Movers.this, ConfirmActivity.class));
                        }

                    }
                });
            }
        });
    }
}