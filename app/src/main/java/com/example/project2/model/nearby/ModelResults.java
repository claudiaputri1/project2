package com.example.project2.model.nearby;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ModelResults implements Serializable {

    @SerializedName("geometry")
    private  ModelGeometry modelGeometry;

    @SerializedName("name")
    private String name;

    @SerializedName("vicinity")
    private String vicinity;

    @SerializedName("place_id")
    private String placeId;

    @SerializedName("rating")
    private double rating;

    public ModelGeometry getModelGeometry() {
        return modelGeometry;
    }

    public void setModelGeometry(ModelGeometry modelGeometry) {
        this.modelGeometry = modelGeometry;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity() {
        this.vicinity = vicinity;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}