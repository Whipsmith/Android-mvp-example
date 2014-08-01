package com.example.androidmontreal.mvp.domain.event.event;


public class RaceResultCreationEvent {

    private long result;

    public RaceResultCreationEvent(long result) {
        this.result = result;
    }

    public long getResult() {
        return result;
    }
}
