package com.example.conceptsbreakdown6.ui.settings.email;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.conceptsbreakdown6.SessionManager;

public class ChangeEmailViewModel extends ViewModel {

    private SessionManager sessionManager;
    private ObservableField<String> email = new ObservableField<>();
    public ChangeEmailViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void changeEmail() {
        String newEmail = email.get();
        if(newEmail != null && !newEmail.isEmpty()) {
            sessionManager.changeEmail(newEmail);
        }
    }
    public ObservableField<String> getEmail() {
        return email;
    }
}
