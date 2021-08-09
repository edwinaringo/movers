package com.example.movers_app;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class OrdersActivity extends AppCompatActivity {
    @BindView(R.id.text_view_result)
    TextView textViewResult;
//    @BindView(R.id.recyclerView)
//    RecyclerView mRecyclerView;
//    private OrdersListAdapter mAdapter;


    private MovingOrders mMovingOrders;
    private List<MovingOrders> ordersList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);

        ButterKnife.bind(this);

        MoversAPI client = MoversClient.getClient();
        Call<List<MovingOrders>> call =client.getMovingOrderByUserName("Johhny");
        call.enqueue(new Callback<List<MovingOrders>>() {
            @Override
            public void onResponse(Call<List<MovingOrders>> call, Response<List<MovingOrders>> response) {

                if(!response.isSuccessful()){ //reposne status between 200 and 300....we found what we were lookng for
                    textViewResult.setText("Code"+response.code());
                    return;
                }
                List<MovingOrders> userMovingOrders= response.body();

                for(MovingOrders userMovingOrder : userMovingOrders){
                    String content = "ID: "+userMovingOrder.getId()+"\n" +"User Name: "+userMovingOrder.getUser_name()+"\n"+"Company: "+userMovingOrder.getMoving_company()+"\n\n";

                    textViewResult.setText(content);

                }


            }

            @Override
            public void onFailure(Call<List<MovingOrders>> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });


//        Call<MovingOrders> call = client.getMovingOrderByUserName("diane");
//
//        call.enqueue(new Callback<MovingOrders>() {
//
//            @Override
//            public void onResponse(Call<MovingOrders> call, Response<MovingOrders> response) {
//                if (response.isSuccessful()) {
//                    ordersList= (List<MovingOrders>) response.body();
//
//                    for(MovingOrders movingOrder : ordersList){
//                        String content = "ID: "+movingOrder.getId()+"\n" +"User Name: "+ movingOrder.getUser_name()+"\n"+ "User Email: "+movingOrder.getUser_email()+"\n" +"Company: "+movingOrder.getMoving_company()+"\n\n";
//                        textViewResult.setText(content);
//                    }
//                }else{
//                    textViewResult.setText("Code"+response.code());
//                    Log.d("msg","api response unsuccessful");
//                    return;
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovingOrders> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
//                Log.d("msg",t.getMessage());
////                hideProgressBar();
//                Log.d("msg","api response unsuccessful");
//
//
//            }
//        });

    }


}
