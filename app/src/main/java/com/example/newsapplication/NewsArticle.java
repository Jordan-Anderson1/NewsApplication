package com.example.newsapplication;

import java.util.Random;

public class NewsArticle {

    String title;

    String description;

    String imageUrl;

    NewsArticle(String title, String description){
        this.title = title;
        this.description = description;

        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        this.imageUrl = "https://picsum.photos/450/100?random=" + randomNumber;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
