package com.example.movers_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MoversList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MoverListAdapter moverListAdapter;
    ArrayList<MoverBio> list;
    CardView itemView;
    private MoverListAdapter.RecyclerViewClickListener listener;

    String []  orderInfo;
    String moverName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movers_list);
        Bundle extras = getIntent().getExtras();

        orderInfo = extras.getStringArray("orderInfo");
        itemView = findViewById(R.id.itemView);

        recyclerView = findViewById(R.id.mover_list);
        database = FirebaseDatabase.getInstance().getReference("MoverPrices");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        setOnClickListener();
        moverListAdapter = new MoverListAdapter(this,list, listener,orderInfo);
        recyclerView.setAdapter(moverListAdapter);



        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MoverBio moverBio = dataSnapshot.getValue(MoverBio.class);
//                    moverName=moverBio.getCompanyName();
                    list.add(moverBio);
                }
                moverListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

    private void setOnClickListener() {
        listener = new MoverListAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
//                Intent intent = new Intent(getApplicationContext(),PickupsActivity.class);
//
//                orderInfo[5]=moverName;
//                intent.putExtra("orderInfo",orderInfo);
//                startActivity(intent);
            }
        };
    }
}