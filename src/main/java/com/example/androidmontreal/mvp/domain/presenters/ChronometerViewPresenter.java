package com.example.androidmontreal.mvp.domain.presenters;

import com.example.androidmontreal.mvp.domain.models.ChronometerModel;
import com.example.androidmontreal.mvp.infrastructure.adapters.HandlerAdapter;
import com.example.androidmontreal.mvp.domain.event.event.RaceResultCreationEvent;
import com.example.androidmontreal.mvp.domain.views.ChronometerView;
import de.greenrobot.event.EventBus;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ChronometerViewPresenter implements Presenter<ChronometerView> {
    private ChronometerView view;
    private final ChronometerModel model;
    private final HandlerAdapter handler;
    private EventBus eventBus;

    private long initialTime;
    private boolean isTimerRunning;

    @Inject
    public ChronometerViewPresenter(ChronometerModel model, HandlerAdapter handler, EventBus eventBus) {
        this.handler = handler;
        this.model = model;
        this.eventBus = eventBus;
    }

    @Override
    public void plugView(ChronometerView chronometerView) {
        view = chronometerView;
        model.setObserver(view);
    }


    public void onStartButtonClicked() {
        isTimerRunning = true;
        initialTime = System.currentTimeMillis();
        timerRunnable.run();
        view.displayStopButton();
    }

    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            if (isTimerRunning) {
                long delta = System.currentTimeMillis() - initialTime;
                initialTime = System.currentTimeMillis();
                model.addTime(delta);
                handler.postDelayed(timerRunnable, 100);
            }
        }
    };

    public void onResetButtonClicked() {
        initialTime = System.currentTimeMillis();
        handler.removeCallbacks(timerRunnable);

        long currentTime = model.getCurrentTime();
        eventBus.post(new RaceResultCreationEvent(currentTime));

        model.resetTime();
        view.displayStartButton();
    }

    public void onStopButtonClicked() {
        isTimerRunning = false;
        handler.removeCallbacks(timerRunnable);
        view.displayResumeButton();
    }
}