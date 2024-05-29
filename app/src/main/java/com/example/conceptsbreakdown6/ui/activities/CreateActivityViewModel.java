package com.example.conceptsbreakdown6.ui.activities;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.conceptsbreakdown6.reps.ActivityRepository;

public class CreateActivityViewModel extends ViewModel {

    private ActivityRepository activityRepository;

    private ObservableField<String> title = new ObservableField<>();
    private ObservableField<String> description = new ObservableField<>();
    private ObservableField<String> local = new ObservableField<>();
    private ObservableField<String> turma = new ObservableField<>();
    private ObservableField<String> horario = new ObservableField<>();


    public CreateActivityViewModel() {
        activityRepository = new ActivityRepository();
    }

    public void registerActivity() {
        //validate the new activity
    }

    public ObservableField<String> getTitle() {
        return title;
    }

    public ObservableField<String> getDescription() {
        return description;
    }

    public ObservableField<String> getLocal() {
        return local;
    }

    public ObservableField<String> getTurma() {
        return turma;
    }

    public ObservableField<String> getHorario() {
        return horario;
    }
}
