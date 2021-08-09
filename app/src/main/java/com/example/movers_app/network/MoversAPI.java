package com.example.movers_app.network;

import com.example.movers_app.models.MovingOrders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MoversAPI {
//    @GET("movingorders/user/{userName}")
//    Call<MovingOrders> getMovingOrderByUserName(@Path("userName") String userName);

    @GET("movingorders/user/{userName}")
    Call<List<MovingOrders>> getMovingOrderByUserName(@Path("userName") String userName);


}
