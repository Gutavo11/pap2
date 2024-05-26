package com.example.conceptsbreakdown6.ui.register;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.conceptsbreakdown6.SessionManager;

public class RegisterViewModel extends ViewModel {

    private SessionManager sessionManager;

    private LiveData<Boolean> registerStatus;

    private ObservableField<String> name = new ObservableField<>();
    private ObservableField<String> numeroInstitucional = new ObservableField<>();
    private ObservableField<String> email = new ObservableField<>();
    private ObservableField<String> password = new ObservableField<>();


    public RegisterViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        this.registerStatus = sessionManager.getRegisterStatus();
    }

    public void register() {
        sessionManager.register(name.get(), numeroInstitucional.get(), email.get(), password.get());
    }


    public ObservableField<String> getName() {
        return name;
    }
    public ObservableField<String> getNumeroInstitucional() {
        return numeroInstitucional;
    }
    public ObservableField<String> getEmail() {
        return email;
    }
    public ObservableField<String> getPassword() {
        return password;
    }
    public LiveData<Boolean> getRegisterStatus() {
        return registerStatus;
    }
}
