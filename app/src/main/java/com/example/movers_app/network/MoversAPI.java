package com.example.movers_app.network;

import com.example.movers_app.models.MovingOrders;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MoversAPI {
    @GET("movingorders/user/{userName}")
    Call<List<MovingOrders>> getMovingOrderByUserName(@Path("userName") String userName);

//    @POST("movingorders/new")
//    Call<MovingOrders> postMovingOrder(@Body RequestBody body);

    @POST("movingorders/new")
    Call<MovingOrders> postMovingOrder(@Body MovingOrders movingOrders);



}
