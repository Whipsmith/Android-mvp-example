package com.example.androidmontreal.mvp.domain.models;

public class ChronometerModel {

    private ChronometerModelObserver observer;
    private long currentTime;

    public void setObserver(ChronometerModelObserver observer) {
        this.observer = observer;
    }

    public void addTime(long delta) {
        currentTime += delta;
        notifyTimeChangedEvent();
    }

    public void resetTime() {
        this.currentTime = 0;
        notifyTimeChangedEvent();
    }

    private void notifyTimeChangedEvent() {
        observer.onTimeChanged(currentTime);
    }

    public long getCurrentTime() {
        return currentTime;
    }
}
