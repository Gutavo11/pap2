package com.example.conceptsbreakdown6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conceptsbreakdown6.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity {

    private ActivityAuthBinding binding;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = SessionManager.getInstance(this.getApplicationContext());
        sessionManager.isLoggedIn();

        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
