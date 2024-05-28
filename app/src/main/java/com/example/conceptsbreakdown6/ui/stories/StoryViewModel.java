package com.example.conceptsbreakdown6.ui.stories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.conceptsbreakdown6.api.model.StoryModel;
import com.example.conceptsbreakdown6.reps.StoryRepository;

import java.util.List;

public class StoryViewModel extends ViewModel {

    private LiveData<List<StoryModel>> stories;
    private StoryRepository storyRepository;

    public StoryViewModel() {
        storyRepository = new StoryRepository();
        storyRepository.fetchStories();
        stories = storyRepository.getStories();
    }

    public void loadStories() {
        storyRepository.fetchStories();
    }

    public LiveData<List<StoryModel>> getStories() {
        return stories;
    }
}
