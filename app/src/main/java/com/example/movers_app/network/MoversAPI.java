package com.example.movers_app.network;

import com.example.movers_app.models.MovingOrders;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MoversAPI {
    @GET("movingorders/{id}")
    Call<MovingOrders> getMovingOrderById(@Path("event_id") String id);
}
