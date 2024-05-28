package com.example.conceptsbreakdown6.ui.settings.name;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.conceptsbreakdown6.SessionManager;

public class ChangeNameViewModelFactory implements ViewModelProvider.Factory {

    private final SessionManager sessionManager;

    public ChangeNameViewModelFactory(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ChangeNameViewModel.class)) {
            return (T) new ChangeNameViewModel(sessionManager);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}
