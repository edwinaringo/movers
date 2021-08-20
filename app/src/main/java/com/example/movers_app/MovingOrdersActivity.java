package com.example.movers_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.movers_app.adapters.MovingOrdersListAdapter;
import com.example.movers_app.models.MovingOrders;
import com.example.movers_app.network.MoversAPI;
import com.example.movers_app.network.MoversClient;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovingOrdersActivity  extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private FirebaseAuth mAuth;

    private String userName;

    private MovingOrdersListAdapter mAdapter;
    private MovingOrders mMovingOrders;
    private List<MovingOrders> movingOrdersList = new ArrayList<>();

    private final int ID_HOME =1;
    private final int ID_ADD =2;
    private final int ID_ORDERS=3;
    private final int ID_ACCOUNT =4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_orders);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

//        Intent intent = getIntent();
//        userName= intent.getStringExtra("username");

        userName=mAuth.getCurrentUser().getUid();

        MoversAPI client = MoversClient.getClient();
        Call<List<MovingOrders>> call = client.getMovingOrderByUserName(userName);

        call.enqueue(new Callback<List<MovingOrders>>() {
            @Override
            public void onResponse(Call<List<MovingOrders>> call, Response<List<MovingOrders>> response) {
                if(response.isSuccessful()){
                    movingOrdersList =response.body();
                    mAdapter = new MovingOrdersListAdapter(getApplicationContext(),movingOrdersList);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                }else{
                Log.d("msg","api response unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<List<MovingOrders>> call, Throwable t) {
                Log.d("msg",t.getMessage());
//                hideProgressBar();
                Log.d("msg","api response unsuccessful");
            }
        });

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

//                        Log.i("current activity","home");
                        Intent intent2 = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent2);

                        break;
                    }
                    case ID_ADD: {

                        Intent intent3 = new Intent(getApplicationContext(), MovingOrdersActivity.class);
                        startActivity(intent3);
                        break;
                    }
                    case ID_ORDERS: {
                        bottomNavigation.show(ID_ORDERS,true);
                        Log.i("current activity","home");
                        break;
                    }
                    case ID_ACCOUNT:{
                        Intent intent4 = new Intent(getApplicationContext(),ProfileActivity.class);
                        startActivity(intent4);
                        break;}
                    default:
                    {
                        Log.i("current activity","default on switch");

//                        Toast.makeText(HomeActivity.this, "Home",Toast.LENGTH_SHORT).show();

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
        bottomNavigation.show(ID_ORDERS,true);

    }

}
