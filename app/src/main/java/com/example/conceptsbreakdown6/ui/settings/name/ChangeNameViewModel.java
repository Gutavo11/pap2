package com.example.conceptsbreakdown6.ui.settings.name;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.conceptsbreakdown6.SessionManager;

public class ChangeNameViewModel extends ViewModel {
    private SessionManager sessionManager;
    private ObservableField<String> name = new ObservableField<>();

    public ChangeNameViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void validateName() {
        String newName = name.get();
        if(newName != null && !newName.isEmpty()) {
            sessionManager.changeName(newName);
        }
    }

    public ObservableField<String> getName() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }
}