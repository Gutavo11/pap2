package com.example.conceptsbreakdown6.api;

import com.example.conceptsbreakdown6.api.model.ChangeNameRequest;
import com.example.conceptsbreakdown6.api.model.LoginRequest;
import com.example.conceptsbreakdown6.api.model.NewsResponse;
import com.example.conceptsbreakdown6.api.model.RegisterRequest;
import com.example.conceptsbreakdown6.api.model.RegisterResponse;
import com.example.conceptsbreakdown6.api.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("login-user")
    Call<UserModel> login(@Body LoginRequest loginRequest);

    @POST("register-user")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("change-name")
    Call<UserModel> changeName(@Body ChangeNameRequest changeNameRequest);

    @GET("logout")
    Call<Void> logout();

    @GET("getStories")
    Call<List<NewsResponse>> fetchNews();

    @GET("stories/{id}")
    Call<NewsResponse> fetchNews(@Path("id") int id);
}
