package com.example.androidmontreal.mvp.domain.presenters;

import com.example.androidmontreal.mvp.domain.event.event.RaceResultCreationEvent;
import com.example.androidmontreal.mvp.domain.models.RaceResultsModel;
import com.example.androidmontreal.mvp.domain.views.RaceResultsView;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RaceResultsViewPresenter  implements Presenter<RaceResultsView> {

    private RaceResultsView view;
    private RaceResultsModel model;

    @Inject
    public RaceResultsViewPresenter(RaceResultsModel model) {
        this.model = model;
    }

    @Override
    public void plugView(RaceResultsView view) {
        this.view = view;
        model.setObserver(view);
    }




    public void onEvent(RaceResultCreationEvent result) {
        model.addRaceResult(result.getResult());
    }

    public void onClearButtonClicked() {
        view.clearRaceResultsList();
    }
}