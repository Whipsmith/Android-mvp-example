package com.example.androidmontreal.mvp.domain.models;

import javax.inject.Inject;
import java.util.ArrayList;

public class RaceResultsModel {

    @Inject
    public RaceResultsModel() {
    }

    private ArrayList<Long> results = new ArrayList<Long>();
    private RaceResultsModelObserver observer;

    public void addRaceResult(long result) {
        results.add(result);
        observer.onRaceResultAdded(result);
    }

    public void setObserver(RaceResultsModelObserver observer) {
        this.observer = observer;
    }
}