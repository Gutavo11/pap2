package com.example.conceptsbreakdown6.ui.welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.conceptsbreakdown6.R;
import com.example.conceptsbreakdown6.databinding.FragmentWelcomeBinding;

public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;
    private NavController navController;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        WelcomeViewModel welcomeViewModel = new ViewModelProvider(this).get(WelcomeViewModel.class);

        binding = FragmentWelcomeBinding.inflate(inflater, container, false);

        binding.bntLogin.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_welcomeFragment_to_loginFragment2);
        });
        binding.btnRegister.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_welcomeFragment_to_registerFragment2);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
