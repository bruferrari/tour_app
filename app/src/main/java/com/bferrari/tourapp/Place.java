package com.bferrari.tourapp;

/**
 * Created by bferrari on 07/11/17.
 */

public class Place {

    private String name;
    private String address;
    private int imageResId;

    public Place(String name, String address, int imageResId) {
        this.name = name;
        this.address = address;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResId() {
        return imageResId;
    }
}
