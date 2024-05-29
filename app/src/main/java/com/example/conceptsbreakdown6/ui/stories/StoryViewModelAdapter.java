package com.example.conceptsbreakdown6.ui.stories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conceptsbreakdown6.api.model.StoryModel;
import com.example.conceptsbreakdown6.databinding.ItemStoryBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class StoryViewModelAdapter extends RecyclerView.Adapter<StoryViewModelAdapter.ViewHolder> {

    private List<StoryModel> stories = new ArrayList<>();

    public StoryViewModelAdapter(List<StoryModel> stories) {
        this.stories = stories;
    }

    public void updateStories(List<StoryModel> stories) {
        this.stories = stories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StoryViewModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemStoryBinding itemStoryBinding = ItemStoryBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemStoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewModelAdapter.ViewHolder holder, int position) {
        StoryModel storyModel = stories.get(position);
        holder.bind(storyModel);

        Picasso.get().load("https://aeg1.pt/"+storyModel.getImage_path()).into(holder.binding.storyImage);

        //set click listener for each story item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoryModel newsResponse = stories.get(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemStoryBinding binding;

        public ViewHolder(ItemStoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(StoryModel storyModel) {
            String truncatedContent = truncateContent(storyModel.getContent(), 180);
            storyModel.setContent(truncatedContent);
            binding.setStory(storyModel);
            binding.executePendingBindings();
        }

        private String truncateContent(String content, int maxLength) {
            if (content.length() > maxLength) {
                return content.substring(0, maxLength) + "...";
            } else {
                return content;
            }
        }
    }
}
