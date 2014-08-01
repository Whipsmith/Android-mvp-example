package com.example.androidmontreal.mvp.infrastructure.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.example.androidmontreal.R;
import com.example.androidmontreal.mvp.domain.presenters.ChronometerViewPresenter;
import com.example.androidmontreal.mvp.domain.views.ChronometerView;
import com.example.androidmontreal.mvp.infrastructure.DIApplication;
import com.example.androidmontreal.mvp.infrastructure.activities.DIActivity;
import com.example.androidmontreal.utils.RaceResultUtil;

import javax.inject.Inject;

public class AndroidChronometerView extends LinearLayout implements ChronometerView {

    @InjectView(R.id.timerText)
    TextView timerText;
    @InjectView(R.id.startButton)
    Button startButton;

    @Inject
    ChronometerViewPresenter presenter;

    public AndroidChronometerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }




    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ((DIActivity) getContext()).getActivityGraph().inject(this);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.startButton)
    public void startButtonClick() {
        presenter.onStartButtonClicked();
    }

    @OnClick(R.id.reset_button)
    public void onResetClicked() {
        presenter.onResetButtonClicked();
    }

    @Override
    public void displayStartButton() {
        startButton.setText(R.string.start_time);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartButtonClicked();
            }
        });
    }

    @Override
    public void onTimeChanged(long timeAmount) {
        String timeAmountAsString = RaceResultUtil.toString(timeAmount);
        timerText.setText(timeAmountAsString);
    }

    @Override
    public void displayStopButton() {
        startButton.setText(R.string.stop_time);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStopButtonClicked();
            }
        });
    }

    @Override
    public void displayResumeButton() {
        startButton.setText(R.string.resume_time);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartButtonClicked();
            }
        });
    }
}