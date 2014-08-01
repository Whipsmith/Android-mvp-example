package com.example.androidmontreal.mvp.infrastructure;

import android.app.Application;
import com.example.androidmontreal.mvp.infrastructure.modules.ApplicationModule;
import dagger.ObjectGraph;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Daniel on 2014-07-28.
 */
public class DIApplication extends Application {

    private static ObjectGraph applicationGraph;

    private static final String TAG = DIApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        applicationGraph = ObjectGraph.create(getModules().toArray());
    }

    /**
     * A list of modules to use for the application graph. Subclasses can
     * override this method to provide additional modules provided they call
     * {@code super.getModules()}.
     */
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new ApplicationModule());
    }

    public static ObjectGraph getApplicationGraph() {
        return applicationGraph;
    }
}
