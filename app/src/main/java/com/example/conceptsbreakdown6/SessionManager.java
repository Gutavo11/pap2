package com.example.conceptsbreakdown6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.conceptsbreakdown6.api.model.UserModel;
import com.example.conceptsbreakdown6.reps.UserRepository;

public class SessionManager {

    //deals with session management logic

    private static SessionManager sessionManager;
    private MutableLiveData<Boolean> loginStatus = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> registerStatus = new MutableLiveData<>(false);
    private MutableLiveData<UserModel> userData = new MutableLiveData<>();
    private  UserRepository userRepository;
    private Context context;
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    private SessionManager(Context context) {
        this.context = context.getApplicationContext();
        //initialize code
        userRepository = new UserRepository();
        sharedPreferences = context.getSharedPreferences("session_data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        isLoggedIn();
    }

    public static synchronized SessionManager getInstance(Context context) {
        if (sessionManager == null) {
            sessionManager = new SessionManager(context);
        }
        return sessionManager;
    }

    public void isLoggedIn() {
        if(sharedPreferences.getBoolean("is_logged_in", false)) {
            navigateToMainActivity();
        }
    }

    public void login(String email, String password) {
        userRepository.login(email, password, new UserRepository.LoginCallback() {
            @Override
            public void onSuccess(UserModel user) {
                //save user data
                //navigate to main activity
                saveUserData(user);
                loginStatus.setValue(true);
                userData.setValue(user);
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
                navigateToAuthActivity();
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

    public void changeName(String name) {
        userRepository.changeName(name, getToken(), new UserRepository.Updateprofile() {
            @Override
            public void onSuccess(UserModel user) {
                userData.setValue(user);
            }
        });
    }

    public void changeEmail(String email) {
        userRepository.changeEmail(email, getToken(), new UserRepository.Updateprofile() {
            @Override
            public void onSuccess(UserModel user) {
                userData.setValue(user);
            }
        });
    }

    public String getToken() {
        return sharedPreferences.getString("auth_token", "");
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

    private void navigateToAuthActivity() {
        Intent intent = new Intent(context, AuthActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    public LiveData<Boolean> getLoginStatus() {
        return loginStatus;
    }
    public LiveData<Boolean> getRegisterStatus() {
        return registerStatus;
    }
    public LiveData<UserModel> getUserData() {
        return userData;
    }

}
