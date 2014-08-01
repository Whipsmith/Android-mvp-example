package com.example.androidmontreal.mvp.infrastructure.modules;

import com.example.androidmontreal.mvp.domain.models.ChronometerModel;
import com.example.androidmontreal.mvp.domain.models.RaceResultsModel;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Daniel on 2014-07-28.
 */
@Module(library = true)
public class ApplicationModule {

    @Provides
    @Singleton
    ChronometerModel provideChronometerModel(){
        return new ChronometerModel();
    }

    @Provides
    @Singleton
    RaceResultsModel provideRaceResultsModel(){
        return new RaceResultsModel();
    }
}
