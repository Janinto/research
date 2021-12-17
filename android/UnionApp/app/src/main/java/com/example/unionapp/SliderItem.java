package com.example.unionapp;

public class SliderItem {

    private int image;

    // Here you can use String variable to store url
    // if you want to load image from the internet

    SliderItem(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }
}
