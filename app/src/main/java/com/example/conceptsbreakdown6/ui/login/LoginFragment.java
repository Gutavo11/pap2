package com.example.conceptsbreakdown6.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.conceptsbreakdown6.MainActivity;
import com.example.conceptsbreakdown6.R;
import com.example.conceptsbreakdown6.SessionManager;
import com.example.conceptsbreakdown6.databinding.FragmentLoginBinding;
import com.example.conceptsbreakdown6.reps.UserRepository;

public class LoginFragment extends Fragment {

    private LoginViewModel loginViewModel;
    private FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize UserRepository
        UserRepository userRepository = new UserRepository();

        // Initialize SessionManager with UserRepository
        SessionManager sessionManager = new SessionManager(requireContext(), userRepository);

        // Create ViewModelFactory
        LoginViewModelFactory factory = new LoginViewModelFactory(sessionManager);

        //initializes viewmodel
        loginViewModel = new ViewModelProvider(this, factory).get(LoginViewModel.class);

        //bind viewmodel into layout
        binding.setViewModel(loginViewModel);

        //set lifecycle owner to observe livedata
        binding.setLifecycleOwner(this);

        //binds button click
        binding.btnLogin.setOnClickListener(v -> {
            loginViewModel.login();
        });

        //observes the login status
        loginViewModel.getLoginStatus().observe(getViewLifecycleOwner(), loginStatus -> {
            if(loginStatus) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        //handles back button
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                // Perform your custom actions here

                // If you want to navigate back
                NavHostFragment.findNavController(LoginFragment.this).navigateUp();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
