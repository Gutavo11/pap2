package com.example.conceptsbreakdown6.reps;

import com.example.conceptsbreakdown6.api.ApiClient;
import com.example.conceptsbreakdown6.api.ApiService;
import com.example.conceptsbreakdown6.api.model.ChangeEmailRequest;
import com.example.conceptsbreakdown6.api.model.ChangeNameRequest;
import com.example.conceptsbreakdown6.api.model.LoginRequest;
import com.example.conceptsbreakdown6.api.model.RegisterRequest;
import com.example.conceptsbreakdown6.api.model.RegisterResponse;
import com.example.conceptsbreakdown6.api.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private ApiService apiService;

    public UserRepository() {

    }

    public void login(String name, String password, LoginCallback callback) {
        LoginRequest loginRequest = new LoginRequest(name, password);

        apiService = ApiClient.getClient().create(ApiService.class);
        Call<UserModel> call = apiService.login(loginRequest);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Login failed");
                }
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void register(String name, String numeroInstitucional, String email, String password, RegisterCallback callback  ) {
        RegisterRequest registerRequest = new RegisterRequest(name, email, password, numeroInstitucional);

        apiService = ApiClient.getClient().create(ApiService.class);
        Call<RegisterResponse> call = apiService.register(registerRequest);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {
                    callback.onError("Register failed");
                }
            }
            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

    public void logout(LogoutCallback callback) {
        apiService = ApiClient.getClient().create(ApiService.class);
        Call<Void> call = apiService.logout();

        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {

                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

    public void changeName(String name, String token, Updateprofile callback) {
        ChangeNameRequest changeNameRequest = new ChangeNameRequest(name);

        apiService = ApiClient.getAuthClient(token).create(ApiService.class);
        Call<UserModel> call = apiService.changeName(changeNameRequest);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    // API call failed, handle error
                    // Log error message or show error to user
                }
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                // API call failed due to network error or other issues
                // Log error message or show error to user
            }
        });
    }

    public void changeEmail(String email, String token, Updateprofile callback) {
        ChangeEmailRequest changeEmailRequest = new ChangeEmailRequest(email);

        apiService = ApiClient.getAuthClient(token).create(ApiService.class);
        Call<UserModel> call = apiService.changeEmail(changeEmailRequest);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    // API call failed, handle error
                    // Log error message or show error to user
                }
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                // API call failed due to network error or other issues
                // Log error message or show error to user
            }
        });
    }

    public interface LoginCallback {
        void onSuccess(UserModel user);
        void onError(String error);
    }

    public interface RegisterCallback {
        void onSuccess();
        void onError(String error);
    }

    public interface LogoutCallback {
        void onSuccess();
    }
    public interface Updateprofile {
        void onSuccess(UserModel user);
    }
}
