package com.example.movers_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movers_app.adapters.MovingOrdersAdapter;
import com.example.movers_app.models.MovingOrders;
import com.example.movers_app.network.MoversAPI;
import com.example.movers_app.network.MoversClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovingOrdersActivity  extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    String userName;

    private MovingOrdersAdapter mAdapter;

    private MovingOrders mMovingOrders;
    private List<MovingOrders> movingOrdersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_orders);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        userName= intent.getStringExtra("username");

        MoversAPI client = MoversClient.getClient();
        Call<MovingOrders> call = client.getMovingOrderByUserName(userName);

        call.enqueue(new Callback<MovingOrders>() {
            @Override
            public void onResponse(Call<MovingOrders> call, Response<MovingOrders> response) {
                if(response.isSuccessful()){
                    mMovingOrders = response.body();
                    movingOrdersList.add(mMovingOrders);
                    mAdapter = new MovingOrdersAdapter(getApplicationContext(),movingOrdersList);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getApplicationContext());
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                }else{
                Log.d("msg","api response unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<MovingOrders> call, Throwable t) {
                Log.d("msg",t.getMessage());
                Log.d("msg","api response unsuccessful");

            }
        });
    }

}
