package com.example.conceptsbreakdown6.ui.login;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.conceptsbreakdown6.SessionManager;

public class LoginViewModel extends ViewModel {

    private final SessionManager sessionManager;
    private LiveData<Boolean> loginStatus;
    private ObservableField<String> email = new ObservableField<>();
    private ObservableField<String> password = new ObservableField<>();

    public LoginViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        this.loginStatus = sessionManager.getLoginStatus();
    }

    public void login() {
        sessionManager.login(email.get(), password.get());
    }

    public LiveData<Boolean> getLoginStatus() {
        return loginStatus;
    }
    public ObservableField<String> getEmail() {
        return email;
    }
    public ObservableField<String> getPassword() {
        return password;
    }

}