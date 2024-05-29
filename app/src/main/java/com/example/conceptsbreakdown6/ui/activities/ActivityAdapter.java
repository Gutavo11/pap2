package com.example.conceptsbreakdown6.ui.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conceptsbreakdown6.api.model.ActivityModel;
import com.example.conceptsbreakdown6.databinding.ItemActivityBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {

    private List<ActivityModel> activities = new ArrayList<>();

    public ActivityAdapter(List<ActivityModel> activities) {
        this.activities = activities;
    }

    public void updateActivities(List<ActivityModel> activities) {
        this.activities = activities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemActivityBinding activityBinding = ItemActivityBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(activityBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityAdapter.ViewHolder holder, int position) {
        holder.bind(activities.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityModel newsResponse = activities.get(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemActivityBinding binding;

        public ViewHolder(ItemActivityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ActivityModel activityModel) {
            binding.setActivity(activityModel);
            binding.executePendingBindings();
        }


    }
}
