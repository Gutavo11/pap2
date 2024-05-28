package com.example.conceptsbreakdown6.ui.settings.profile;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.conceptsbreakdown6.SessionManager;

public class ProfileViewModelFactory implements ViewModelProvider.Factory {

    private final SessionManager sessionManager;

    public ProfileViewModelFactory(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProfileViewModel.class)) {
            return (T) new ProfileViewModel(sessionManager);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
