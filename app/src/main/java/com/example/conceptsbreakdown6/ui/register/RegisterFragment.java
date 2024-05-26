package com.example.conceptsbreakdown6.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.conceptsbreakdown6.MainActivity;
import com.example.conceptsbreakdown6.R;
import com.example.conceptsbreakdown6.SessionManager;
import com.example.conceptsbreakdown6.databinding.FragmentRegisterBinding;
import com.example.conceptsbreakdown6.reps.UserRepository;
import com.example.conceptsbreakdown6.ui.login.LoginViewModelFactory;

public class RegisterFragment extends Fragment {
    private RegisterViewModel registerViewModel;
    private FragmentRegisterBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        // Initialize UserRepository
        UserRepository userRepository = new UserRepository();

        // Initialize SessionManager with UserRepository
        SessionManager sessionManager = new SessionManager(requireContext(), userRepository);

        // Create ViewModelFactory
        RegisterViewModelFactory factory = new RegisterViewModelFactory(sessionManager);

        //create viewmodel
        registerViewModel = new ViewModelProvider(this, factory).get(RegisterViewModel.class);

        //bind viewmodel into the view
        binding.setViewModel(registerViewModel);

        binding.btnRegister.setOnClickListener(view ->{
            registerViewModel.register();
        });

        //observes the register status
        registerViewModel.getRegisterStatus().observe(getViewLifecycleOwner(), registerStatus -> {
            if(registerStatus) {
                NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment2_to_loginFragment2);
            }
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                // Perform your custom actions here

                // If you want to navigate back
                NavHostFragment.findNavController(RegisterFragment.this).navigateUp();
            }
        });

        return binding.getRoot();
    }
}
