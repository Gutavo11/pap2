package com.example.conceptsbreakdown6.ui.register;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.conceptsbreakdown6.SessionManager;

public class RegisterViewModelFactory implements ViewModelProvider.Factory {
    private final SessionManager sessionManager;

    public RegisterViewModelFactory(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RegisterViewModel.class)) {
            return (T) new RegisterViewModel(sessionManager);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}