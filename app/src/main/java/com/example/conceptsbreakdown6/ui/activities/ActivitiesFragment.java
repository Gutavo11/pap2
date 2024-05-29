package com.example.conceptsbreakdown6.ui.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conceptsbreakdown6.R;
import com.example.conceptsbreakdown6.api.model.ActivityModel;
import com.example.conceptsbreakdown6.databinding.FragmentActivitiesBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesFragment extends Fragment {

    private FragmentActivitiesBinding binding;
    private ActivityAdapter activityAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentActivitiesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //initialize the viewModel
        ActivitiesViewModel activitiesViewModel = new ViewModelProvider(this).get(ActivitiesViewModel.class);

        //initialize the adapter
        activityAdapter = new ActivityAdapter(new ArrayList<>());

        //display data
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(activityAdapter);

        activitiesViewModel.getActivities().observe(getViewLifecycleOwner(), new Observer<List<ActivityModel>>() {
            @Override
            public void onChanged(List<ActivityModel> activityModel) {
                if(activityModel != null) {
                    activityAdapter.updateActivities(activityModel);
                }
            }
        });

        //set fab click listener
        binding.fab.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_nav_activities_to_createActivityFragment);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
