package com.example.conceptsbreakdown6.ui.settings.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.conceptsbreakdown6.R;
import com.example.conceptsbreakdown6.SessionManager;
import com.example.conceptsbreakdown6.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile ,container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        // Gets sessionManager instance
        SessionManager sessionManager = SessionManager.getInstance(requireContext());

        //initialize factory
        ProfileViewModelFactory factory = new ProfileViewModelFactory(sessionManager);

        //initializes viewmodel
        profileViewModel = new ViewModelProvider(this, factory).get(ProfileViewModel.class);

        //bind viewmodel into layout
        binding.setViewModel(profileViewModel);

        //set lifecycle owner to observe livedata
        binding.setLifecycleOwner(this);

        //binds Logout button
        binding.btnLogout.setOnClickListener(v -> {
            profileViewModel.logout();
        });

        //binds ChangeName button
        binding.btnChangeName.setOnClickListener(v -> {
            navController.navigate(R.id.action_profileFragment_to_changeNameFragment2);
        });

        //binds ChangePassword button
        binding.btnChangePassword.setOnClickListener(v -> {
            navController.navigate(R.id.action_profileFragment_to_changePasswordFragment2);
        });

        //binds ChangeEmail button
        binding.btnChangeEmail.setOnClickListener(v ->{
                navController.navigate(R.id.action_profileFragment_to_changeEmailFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
