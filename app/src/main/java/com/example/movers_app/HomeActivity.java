package com.example.movers_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.movers_app.adapters.HomeActivityAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;

    HomeActivityAdapter homeActivityAdapter;

    ArrayList<MoverBio> list;

    CardView itemView;
    private HomeActivityAdapter.RecyclerViewClickListener listener;

//    String []  orderInfo;
    String moverName;

    private final int ID_HOME =1;
    private final int ID_ADD =2;
    private final int ID_ORDERS=3;
    private final int ID_ACCOUNT =4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_movers_list);
        Bundle extras = getIntent().getExtras();



//        orderInfo = extras.getStringArray("orderInfo");
        itemView = findViewById(R.id.itemView);
        recyclerView = findViewById(R.id.mover_list);
        database = FirebaseDatabase.getInstance().getReference("MoverPrices");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        setOnClickListener();
        homeActivityAdapter = new HomeActivityAdapter(this,list, listener);
        recyclerView.setAdapter(homeActivityAdapter);



        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MoverBio moverBio = dataSnapshot.getValue(MoverBio.class);
//                    moverName=moverBio.getCompanyName();
                    list.add(moverBio);
                }
                homeActivityAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//
        MeowBottomNavigation bottomNavigation =findViewById(R.id.bottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ADD,R.drawable.ic_baseline_add_circle_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ORDERS,R.drawable.ic_baseline_request_quote_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ACCOUNT,R.drawable.ic_baseline_person_24));

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
//                Toast.makeText(getApplicationContext(), model.getId() +"", Toast.LENGTH_SHORT).show();
                switch(model.getId()){
                    case ID_HOME: {

                        Toast.makeText(HomeActivity.this, "Home",Toast.LENGTH_SHORT).show();

                        break;
                    }
                    case ID_ADD: {

                        Intent intent2 = new Intent(HomeActivity.this, HouseActivity.class);
                        startActivity(intent2);
                        break;
                    }
                    case ID_ORDERS: {

                        Intent intent3 = new Intent(HomeActivity.this, MovingOrdersActivity.class);
                        startActivity(intent3);
                        break;
                    }
                    case ID_ACCOUNT:{
                        Intent intent4 = new Intent(HomeActivity.this,ProfileActivity.class);
                        startActivity(intent4);
                        break;}
                    default:
                    {
                        Toast.makeText(HomeActivity.this, "Home",Toast.LENGTH_SHORT).show();

                    };
                }
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                // YOUR CODES
                return null;
            }
        });

//        bottomNavigation.setCount(ID_NOTIFICATION,"4");
        bottomNavigation.show(ID_HOME,true);




    }

    private void setOnClickListener() {
        listener = new HomeActivityAdapter.RecyclerViewClickListener() {
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