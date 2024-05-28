package com.example.conceptsbreakdown6.ui.settings.email;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.conceptsbreakdown6.SessionManager;

public class ChangeEmailViewModelFactory implements ViewModelProvider.Factory {

    private final SessionManager sessionManager;

    public ChangeEmailViewModelFactory(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ChangeEmailViewModel.class)) {
            return (T) new ChangeEmailViewModel(sessionManager);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}
