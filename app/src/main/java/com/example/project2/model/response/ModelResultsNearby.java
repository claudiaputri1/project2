package com.example.project2.model.response;

import com.example.project2.model.nearby.ModelResults;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelResultsNearby {

    @SerializedName("result")
    private List<ModelResults> modelResults;

    public List<ModelResults> getModelResults() {
        return modelResults;
    }

    public void setModelResults(List<ModelResults> modelResults) {
        this.modelResults = modelResults;
    }
}