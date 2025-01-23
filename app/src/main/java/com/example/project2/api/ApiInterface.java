package com.example.project2.api;

import com.example.project2.model.response.ModelResultsNearby;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("place/nearbysearch/json")
    Call<ModelResultsNearby> getDataResult(@Query("key") String key,
                                           @Query("keyword") String keyword,
                                           @Query("location") String location,
                                           @Query("rankby") String rankby);
}
