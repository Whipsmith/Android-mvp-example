package com.example.androidmontreal.mvp.infrastructure.activities;

import android.app.Activity;
import android.os.Bundle;
import com.example.androidmontreal.mvp.infrastructure.DIApplication;
import com.example.androidmontreal.mvp.infrastructure.modules.ActivityModule;
import dagger.ObjectGraph;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Daniel on 2014-07-28.
 */
public class DIActivity extends Activity{
    private ObjectGraph activityGraph;
    protected final static String TAG = DIActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create the activity graph by .plus-ing our modules onto the application graph.
//        DIApplication application = (DIApplication) getApplication();
        activityGraph = DIApplication.getApplicationGraph().plus(getModules().toArray());
        // Inject ourselves so subclasses will have dependencies fulfilled when this method returns.
        activityGraph.inject(this);
    }

    @Override
    protected void onDestroy() {
        // Eagerly clear the reference to the activity graph to allow it to be garbage collected as
        // soon as possible.
        activityGraph = null;
        super.onDestroy();
    }

    /**
     * A list of modules to use for the individual activity graph.
     * Subclasses can override this method to provide additional modules
     * provided they call and include the modules returned by calling
     * {@code super.getModules()}.
     */
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new ActivityModule());
    }

    /**
     * Inject the supplied {@code object} using the activity-specific graph.
     */
    public void inject(Object object) {
        activityGraph.inject(object);
    }

    public ObjectGraph getActivityGraph() {
        return activityGraph;
    }
}
