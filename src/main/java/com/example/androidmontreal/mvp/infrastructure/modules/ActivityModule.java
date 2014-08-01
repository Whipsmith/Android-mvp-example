package com.example.androidmontreal.mvp.infrastructure.modules;

import android.os.Handler;
import com.example.androidmontreal.mvp.domain.presenters.ChronometerViewPresenter;
import com.example.androidmontreal.mvp.domain.presenters.RaceResultsViewPresenter;
import com.example.androidmontreal.mvp.domain.views.ChronometerView;
import com.example.androidmontreal.mvp.infrastructure.activities.DIActivity;
import com.example.androidmontreal.mvp.infrastructure.activities.RaceActivity;
import com.example.androidmontreal.mvp.infrastructure.adapters.HandlerAdapter;
import com.example.androidmontreal.mvp.infrastructure.views.AndroidChronometerView;
import com.example.androidmontreal.mvp.infrastructure.views.AndroidRaceResultsView;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

import javax.inject.Singleton;

/**
 * Created by Daniel on 2014-07-28.
 */

@Module(injects = {RaceActivity.class,
        AndroidChronometerView.class,
        AndroidRaceResultsView.class},
        addsTo = ApplicationModule.class,
        library = true)
public class ActivityModule {
//    private final DIActivity activity;

//    public ActivityModule(DIActivity activity) {
//        this.activity = activity;
//    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return new EventBus();
    }

    @Provides
    Handler provideHandler() {
        return new Handler();
    }



//    @Provides
//    @Singleton
//    ChronometerViewPresenter provideChronometerViewPresenter(ChronometerViewPresenter presenter) {
//        return presenter;
//    }
//
//    @Provides
//    @Singleton
//    RaceResultsViewPresenter provideRaceResultsViewPresenter(RaceResultsViewPresenter presenter) {
//        return presenter;
//    }
}
