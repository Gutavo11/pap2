package com.example.conceptsbreakdown6.reps;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.conceptsbreakdown6.api.ApiClient;
import com.example.conceptsbreakdown6.api.ApiService;
import com.example.conceptsbreakdown6.api.model.ActivityModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRepository {

    //fetch data from DB
    private final ApiService apiService;

    public ActivityRepository() {
        this.apiService = ApiClient.getClient().create(ApiService.class);
    }

    public LiveData<List<ActivityModel>> fetchActivities() {
        MutableLiveData<List<ActivityModel>> data = new MutableLiveData<>();

        apiService.fetchActivities().enqueue(new Callback<List<ActivityModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<ActivityModel>> call, @NonNull Response<List<ActivityModel>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                } else {
                    Log.d("Api Error: ", "Falha na resposta: " + response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<ActivityModel>> call, Throwable t) {
                Log.e("Api Error: ", "Falha no request", t);
            }
        });

        return data;
    }
}
