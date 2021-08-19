package com.example.movers_app.network;

import com.example.movers_app.models.MovingOrders;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MoversAPI {
    @GET("movingorders/user/{userName}")
    Call<List<MovingOrders>> getMovingOrderByUserName(@Path("userName") String userName);
    @GET("movingorders/company/{movingCompany}")
    Call<List<MovingOrders>> getMovingOrderByCompanyName(@Path("movingCompany") String movingCompany);


    @POST("movingorders/new")
    Call<MovingOrders> postMovingOrder(@Body MovingOrders movingOrders);

    @PATCH("/movingorders/update/{id}/{status}")
    Call<MovingOrders> updateMovingOrderStatus(@Path("id")int id,@Path("status")String status,@Body MovingOrders movingOrders);

//    @PUT("/movingorders/update/{id}/{status}")
//    Call<MovingOrders> updateMovingOrderStatus(@Path("id")int id,@Path("status")String status);



}
