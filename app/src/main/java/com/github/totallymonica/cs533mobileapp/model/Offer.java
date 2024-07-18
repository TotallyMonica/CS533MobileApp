package com.github.totallymonica.cs533mobileapp.model;

/**
 * CS533 Mobile App
 * https://github.com/TotallyMonica/CS533MobileApp
 * Created on 18-Feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */
public class Offer {
    String image;

    public Offer(String image) {
        this.image = image;
    }

    public Offer() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
