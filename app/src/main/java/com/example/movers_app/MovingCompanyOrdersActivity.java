package com.example.movers_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movers_app.adapters.MovingCompanyOrdersListAdapter;
import com.example.movers_app.adapters.MovingOrdersListAdapter;
import com.example.movers_app.models.MovingOrders;
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

public class MovingCompanyOrdersActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private String companyName;

    private MovingCompanyOrdersListAdapter mAdapter;
    private MovingOrders mMovingOrders;
    private List<MovingOrders> movingOrdersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_company_orders);
        ButterKnife.bind(this);

        Intent intent = getIntent();



        companyName= intent.getStringExtra("companyName");
        Log.i("name",companyName);

        MoversAPI client = MoversClient.getClient();
        Call<List<MovingOrders>> call = client.getMovingOrderByCompanyName(companyName);

        call.enqueue(new Callback<List<MovingOrders>>() {
            @Override
            public void onResponse(Call<List<MovingOrders>> call, Response<List<MovingOrders>> response) {
                if(response.isSuccessful()){
                    movingOrdersList =response.body();
                    mAdapter = new MovingCompanyOrdersListAdapter(getApplicationContext(),movingOrdersList);

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
    }
}
