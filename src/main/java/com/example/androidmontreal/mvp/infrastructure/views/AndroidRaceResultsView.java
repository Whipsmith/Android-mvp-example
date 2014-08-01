package com.example.androidmontreal.mvp.infrastructure.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.*;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;
import com.example.androidmontreal.R;
import com.example.androidmontreal.mvp.domain.models.RaceResultsModelObserver;
import com.example.androidmontreal.mvp.domain.presenters.Presenter;
import com.example.androidmontreal.mvp.domain.presenters.RaceResultsViewPresenter;
import com.example.androidmontreal.mvp.domain.views.RaceResultsView;
import com.example.androidmontreal.mvp.infrastructure.activities.DIActivity;
import com.example.androidmontreal.utils.RaceResultUtil;

import javax.inject.Inject;
import java.util.ArrayList;

public class AndroidRaceResultsView extends LinearLayout implements RaceResultsView {

    @Inject
    RaceResultsViewPresenter presenter;

    @InjectView(R.id.race_results_list_view)
    ListView listView;

    private ArrayList<String> results;
    ArrayAdapter<String> resultsAdapter;

    public AndroidRaceResultsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        results = new ArrayList<String>();
        resultsAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, results);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ((DIActivity) getContext()).getActivityGraph().inject(this);
        ButterKnife.inject(this);

        listView.setAdapter(resultsAdapter);
    }





    @OnClick(R.id.clear_button)
    public void onClearClicked() {
        presenter.onClearButtonClicked();
    }


    @Override
    public void clearRaceResultsList() {
        results.clear();
        resultsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRaceResultAdded(long result) {
        String resultAsString = RaceResultUtil.toString(result);
        results.add(resultAsString);
        resultsAdapter.notifyDataSetChanged();
    }


}