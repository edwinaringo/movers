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


    private EditText mCompanyName, mEmailAddress, mContactInfo, mExtraServices, mInventoryCharges, mPricePerDistance;

    private Button submitPrices;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("MoverPrices");

    DatabaseReference newroot = root.push();//this is to add mover instead of replacing the one previously put on firebase




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movers);

        mCompanyName = findViewById(R.id.companyName);
        mEmailAddress = findViewById(R.id.emailAddress);
        mExtraServices = findViewById(R.id.extraServices);
        mContactInfo = findViewById(R.id.contactInfo);
        mInventoryCharges = findViewById(R.id.inventoryCharges);
        mPricePerDistance= findViewById(R.id.pricePerDistance);

        submitPrices = findViewById(R.id.submitPrices);

        submitPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String companyName = mCompanyName.getText().toString();
                String emailAddress = mEmailAddress.getText().toString();
                String extraService = mExtraServices.getText().toString();
                String contactInfo = mContactInfo.getText().toString();
                String Inventory = mInventoryCharges.getText().toString();
                String pricePerDistance = mPricePerDistance.getText().toString();


                HashMap<String, String> pricesMap = new HashMap<>();

                pricesMap.put("companyName", companyName);
                pricesMap.put("emailAddress", emailAddress);
                pricesMap.put("extraServices", extraService);
                pricesMap.put("contactInfo", contactInfo);
                pricesMap.put("inventory", Inventory);
                pricesMap.put("pricePerDistance", pricePerDistance);

                newroot.setValue(pricesMap)

                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(Movers.this, MovingCompanyOrdersActivity.class));

                        }

                    }
                });
            }
        });
    }
}