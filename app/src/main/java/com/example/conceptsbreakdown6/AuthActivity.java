package com.example.conceptsbreakdown6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conceptsbreakdown6.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity {

    private ActivityAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
