package com.example.conceptsbreakdown6.ui.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.conceptsbreakdown6.SessionManager;

public class LoginViewModelFactory implements ViewModelProvider.Factory {
    private final SessionManager sessionManager;

    public LoginViewModelFactory(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(sessionManager);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
