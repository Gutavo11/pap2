package com.example.conceptsbreakdown6.ui.stories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conceptsbreakdown6.api.model.StoryModel;
import com.example.conceptsbreakdown6.databinding.FragmentStoriesBinding;

import java.util.ArrayList;
import java.util.List;

public class StoryFragment extends Fragment {

    private FragmentStoriesBinding binding;
    private  StoryViewModel storyViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStoriesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //initialize viewmodel
        storyViewModel = new ViewModelProvider(this).get(StoryViewModel.class);

        //initialize the adapter
        StoryViewModelAdapter storyViewModelAdapter = new StoryViewModelAdapter(new ArrayList<>());

        //display data
        RecyclerView recyclerView = binding.recyclerViewStories;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(storyViewModelAdapter);

        storyViewModel.getStories().observe(getViewLifecycleOwner(), new Observer<List<StoryModel>>() {
            @Override
            public void onChanged(List<StoryModel> storyModel) {
                if(storyModel != null) {
                    storyViewModelAdapter.updateStories(storyModel);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
