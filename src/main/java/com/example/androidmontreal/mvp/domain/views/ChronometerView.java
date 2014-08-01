package com.example.androidmontreal.mvp.domain.views;

import com.example.androidmontreal.mvp.domain.models.ChronometerModelObserver;

public interface ChronometerView extends ChronometerModelObserver {

    void displayResumeButton();

    void displayStartButton();

    void displayStopButton();
}
