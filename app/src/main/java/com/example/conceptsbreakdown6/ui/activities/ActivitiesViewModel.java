package com.example.conceptsbreakdown6.ui.activities;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.conceptsbreakdown6.api.model.ActivityModel;
import com.example.conceptsbreakdown6.reps.ActivityRepository;

import java.util.List;

public class ActivitiesViewModel extends ViewModel {

    private ActivityRepository activityRepository;
    private LiveData<List<ActivityModel>> activities;

    public ActivitiesViewModel() {
        activityRepository = new ActivityRepository();
        activities = activityRepository.fetchActivities();
    }

    public void loadActivities() {
        activities = activityRepository.fetchActivities();
    }

    public LiveData<List<ActivityModel>> getActivities() {
        return activities;
    }


}
