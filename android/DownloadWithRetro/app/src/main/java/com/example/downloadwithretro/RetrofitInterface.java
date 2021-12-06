package com.example.downloadwithretro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface RetrofitInterface {


    @POST("/m/download/video")
    Call<Post> getPosts(@Body Post post);

    @GET
    @Streaming
    Call<Post> downloadVideo(@Url String fileName);
}