package com.example.conceptsbreakdown6.ui.settings.profile;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.conceptsbreakdown6.SessionManager;
import com.example.conceptsbreakdown6.api.model.UserModel;
import com.example.conceptsbreakdown6.reps.UserRepository;

public class ProfileViewModel extends ViewModel {

    private LiveData<UserModel> userData;
    private SessionManager sessionManager;

    public ProfileViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        userData = sessionManager.getUserData();
    }

    public LiveData<UserModel> getUserData() {
        return userData;
    }
    public void logout() {
        sessionManager.logout();
    }

}
