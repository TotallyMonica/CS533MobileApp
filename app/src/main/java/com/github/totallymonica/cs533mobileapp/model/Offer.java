package com.github.totallymonica.cs533mobileapp.model;


public class Offer {
    String image;
    String description;

    public Offer() {
    }

    public Offer(String image, String description) {

        this.image = image;
        this.description = description;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
