package com.example.conceptsbreakdown6.ui.settings.password;

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
import com.example.conceptsbreakdown6.databinding.FragmentChangePasswordBinding;

public class ChangePasswordFragment extends Fragment {

    private FragmentChangePasswordBinding binding;
    private ChangePasswordViewModel changePasswordViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_password, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //initialize viewmodel
        changePasswordViewModel = new ViewModelProvider(this).get(ChangePasswordViewModel.class);

        //binds viewmodel to UI
        binding.setViewModel(changePasswordViewModel);

        //set lifecycle owner
        binding.setLifecycleOwner(this);

        //binds button clicks
        binding.btnSaveChanges.setOnClickListener(v -> {
            //chama o viewmodel para o mesmo preparar os dados para realizar o login
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
