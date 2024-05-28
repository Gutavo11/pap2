package com.example.conceptsbreakdown6.reps;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.conceptsbreakdown6.api.model.StoryModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoryRepository {
    private MutableLiveData<List<StoryModel>> stories = new MutableLiveData<>();

    public StoryRepository() {

    }

    public void fetchStories() {
        new FetchNewsTask().execute("https://aeg1.pt");
    }

    private class FetchNewsTask extends AsyncTask<String, Void, List<StoryModel>> {
        @Override
        protected List<StoryModel> doInBackground(String... urls) {
            List<StoryModel> data = new ArrayList<>();
            try {
                Document doc = Jsoup.connect(urls[0]).get();
                Elements newsElements = doc.select("div.border.m-auto.rounded.my-4.shadow.hover\\:shadow-md.flex.flex-col.py-1.px-2");
                for (Element element : newsElements) {
                    String title = element.select("div.uppercase.leading-tight.font-bold").text();
                    String description = element.select("p.mt-2.h-full.overflow-hidden.w-full.text-sm.text-justify").text();
                    String imagePath = element.select("img.m-auto.h-48.w-full.object-cover").attr("src");
                    Log.d("News", "Title: " + title + ", Description: " + description + ", ImagePath: " + imagePath);

                    StoryModel storyModel = new StoryModel(title, description, imagePath);
                    data.add(storyModel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(List<StoryModel> data) {
            stories.setValue(data);
        }
    }

    public LiveData<List<StoryModel>> getStories() {
        return stories;
    }


    /*
    private static class FetchNewsTask extends AsyncTask<String, Void, List<StoryModel>> {
        List<StoryModel> data = new ArrayList<>();
        @Override
        protected List<StoryModel> doInBackground(String... urls) {
            try {
                Document doc = Jsoup.connect(urls[0]).get();
                // Example selector to get news items, replace with actual selector
                Elements newsElements = doc.select("div.border.m-auto.rounded.my-4.shadow.hover\\:shadow-md.flex.flex-col.py-1.px-2");
                for (Element element : newsElements) {
                    String title = element.select("div.uppercase.leading-tight.font-bold").text();
                    String description = element.select("p.mt-2.h-full.overflow-hidden.w-full.text-sm.text-justify").text();
                    String imagePath = element.select("img.m-auto.h-48.w-full.object-cover").attr("src");
                    Log.d("News", "Title: " + title + ", Description: " + description + ", ImagePath: " + imagePath);

                    StoryModel storyModel = new StoryModel(title, description, imagePath);
                    data.add(storyModel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
    }
    */
}