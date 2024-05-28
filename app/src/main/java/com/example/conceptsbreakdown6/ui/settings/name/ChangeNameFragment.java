package com.example.conceptsbreakdown6.ui.settings.name;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.conceptsbreakdown6.R;
import com.example.conceptsbreakdown6.SessionManager;
import com.example.conceptsbreakdown6.databinding.FragmentChangeNameBinding;
import com.example.conceptsbreakdown6.ui.settings.profile.ProfileViewModelFactory;

public class ChangeNameFragment extends Fragment {

    private FragmentChangeNameBinding binding;
    private ChangeNameViewModel changeNameViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_name, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get instance of sessionManager
        SessionManager sessionManager = SessionManager.getInstance(requireContext());

        //initialize factory
        ChangeNameViewModelFactory factory = new ChangeNameViewModelFactory(sessionManager);

        //initialize viewmodel
        changeNameViewModel = new ViewModelProvider(this, factory).get(ChangeNameViewModel.class);

        //binds viewmodel to UI
        binding.setViewModel(changeNameViewModel);

        //set lifecycle owner
        binding.setLifecycleOwner(this);

        //binds button clicks
        binding.btnSaveChanges.setOnClickListener(v -> {
            //chama o viewmodel para o mesmo preparar os dados para realizar o login
            changeNameViewModel.validateName();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
