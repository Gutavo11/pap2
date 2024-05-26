package com.example.conceptsbreakdown6.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;
    private static Retrofit authRetrofit;
    private static final String baseUrl = "https://871d-2001-818-de05-2900-a00e-55e1-d674-a359.ngrok-free.app/api/";

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getAuthClient(String authToken) {
        if (authRetrofit == null) {
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

            clientBuilder.addInterceptor(chain -> {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .header("Authorization", "Bearer " + authToken)
                        .method(original.method(), original.body());
                Request request = requestBuilder.build();
                return  chain.proceed(request);
            });

            OkHttpClient client = clientBuilder.build();

            authRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return authRetrofit;
    }
}
