package com.example.conceptsbreakdown6.ui.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.conceptsbreakdown6.databinding.FragmentCreateActivityBinding;

public class CreateActivityFragment extends Fragment {
    private FragmentCreateActivityBinding binding;
    private CreateActivityViewModel createActivityViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateActivityBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //initialize viewmodel
        createActivityViewModel = new ViewModelProvider(this).get(CreateActivityViewModel.class);

        //set click listener for save button
        binding.btnSaveChanges.setOnClickListener(v -> {
            createActivityViewModel.registerActivity();
        });
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
    }

}