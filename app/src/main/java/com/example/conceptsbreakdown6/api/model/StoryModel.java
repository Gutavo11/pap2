package com.example.conceptsbreakdown6.api.model;

public class StoryModel {
    private String title;
    private String content;
    private String image_path;

    public StoryModel(String title, String content, String imagePath) {
        this.title = title;
        this.content = content;
        this.image_path = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}

