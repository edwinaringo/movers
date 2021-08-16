package com.example.movers_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoverAccount  extends AppCompatActivity implements View .OnClickListener{

    @BindView(R.id.companyName) TextView mCompanyName;
    @BindView(R.id.companyEmail) TextView mCompanyEmail;
    @BindView(R.id.companyContact) TextView mCompanyContact;
    @BindView(R.id.companyExtraServices) TextView mExtraServices;
    @BindView(R.id.inventoryCharges) TextView mInventoryCharges;
    @BindView(R.id.chargePerDistance) TextView mChargesPerDistances;
    @BindView(R.id.moverOrdersButton) Button mMoverOrdersButton;


    DatabaseReference database;
    String companyEmail;
    MoverBio moverBio1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_account);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        Intent intent = getIntent();
        companyEmail = intent.getStringExtra("companyEmail");
        Log.i("emaillogin", companyEmail.toString());

        database = FirebaseDatabase.getInstance().getReference("MoverPrices");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {


                    MoverBio moverBio = dataSnapshot.getValue(MoverBio.class);
                    moverBio1= moverBio;

                    if(moverBio.getEmailAddress().equals(companyEmail)) {
                        Log.i("email", "equal");

                        mCompanyName.setText(moverBio1.getCompanyName());
                        mCompanyEmail.setText(moverBio1.getEmailAddress());
                        mCompanyContact.setText(moverBio1.getContactInfo());
                        mExtraServices.setText(moverBio1.getExtraServices());
                        mInventoryCharges.setText(moverBio1.getInventory());
                        mChargesPerDistances.setText(moverBio1.getPricePerDistance());

                    }else{
                        Log.i("email",moverBio.getCompanyName());


                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mMoverOrdersButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v == mMoverOrdersButton){
            Intent intent =new Intent(getApplicationContext(),MovingCompanyOrdersActivity.class);
            intent.putExtra("companyEmail",companyEmail);
            startActivity(intent);

        }

    }
}
