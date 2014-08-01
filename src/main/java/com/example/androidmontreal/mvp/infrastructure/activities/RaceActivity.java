package com.example.androidmontreal.mvp.infrastructure.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.example.androidmontreal.R;
import com.example.androidmontreal.mvp.domain.presenters.ChronometerViewPresenter;
import com.example.androidmontreal.mvp.domain.presenters.RaceResultsViewPresenter;
import com.example.androidmontreal.mvp.infrastructure.views.AndroidChronometerView;
import com.example.androidmontreal.mvp.infrastructure.views.AndroidRaceResultsView;
import com.example.androidmontreal.mvp.domain.views.ChronometerView;
import com.example.androidmontreal.mvp.domain.views.RaceResultsView;
import de.greenrobot.event.EventBus;

import javax.inject.Inject;

public class RaceActivity extends DIActivity {

    @InjectView(R.id.chronometer)
    AndroidChronometerView chronometerView;

    @InjectView(R.id.raceResults)
    AndroidRaceResultsView raceResultsView;

    @Inject
    RaceResultsViewPresenter raceResultsViewPresenter;

    @Inject
    ChronometerViewPresenter chronometerViewPresenter;

    @Inject
    EventBus eventbus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_main);

        ButterKnife.inject(this);


        chronometerViewPresenter.plugView(chronometerView);
        raceResultsViewPresenter.plugView(raceResultsView);

    }


    @Override
    protected void onResume() {
        super.onResume();
        eventbus.register(raceResultsViewPresenter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        eventbus.unregister(raceResultsViewPresenter);
    }
}