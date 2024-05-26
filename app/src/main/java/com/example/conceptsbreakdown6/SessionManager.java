package com.example.conceptsbreakdown6;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.conceptsbreakdown6.api.model.UserModel;
import com.example.conceptsbreakdown6.reps.UserRepository;

public class SessionManager {

    //deals with session management logic
    private MutableLiveData<Boolean> loginStatus = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> registerStatus = new MutableLiveData<>(false);
    private UserRepository userRepository;
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;
    public SessionManager(Context context, UserRepository userRepository) {
        this.userRepository = userRepository;
        sharedPreferences = context.getSharedPreferences("session_data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void login(String email, String password) {
        userRepository.login(email, password, new UserRepository.LoginCallback() {
            @Override
            public void onSuccess(UserModel user) {
                //save user data
                //navigate to main activity
                saveUserData(user);
                loginStatus.setValue(true);
            }
            @Override
            public void onError(String error) {

            }
        });
    }

    public void logout() {
        userRepository.logout(new UserRepository.LogoutCallback() {
            @Override
            public void onSuccess() {
                //clear session data
                //navigate back to auth activity
                clearSession();
                loginStatus.setValue(false);
            }
        });
    }

    public void register(String name, String numeroInstitucional, String email, String password) {
        userRepository.register(name, numeroInstitucional, email, password, new UserRepository.RegisterCallback() {
            @Override
            public void onSuccess() {
                registerStatus.setValue(true);
            }
            @Override
            public void onError(String error) {
                registerStatus.setValue(false);
            }
        });
    }
    public void saveUserData(UserModel user) {
        editor.putString("username", user.getName());
        editor.putString("email", user.getEmail());
        editor.putString("auth_token", user.getToken());
        editor.putBoolean("is_logged_in", true);
        editor.apply();
    }

    public void clearSession() {
        editor.clear();
        editor.apply();
    }

    public LiveData<Boolean> getLoginStatus() {
        return loginStatus;
    }
    public LiveData<Boolean> getRegisterStatus() {
        return registerStatus;
    }

}
