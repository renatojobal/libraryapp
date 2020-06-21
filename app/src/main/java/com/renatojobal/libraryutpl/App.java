package com.renatojobal.libraryutpl;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.renatojobal.libraryutpl.repository.localdatabase.DataGenerator;

import timber.log.Timber;

public class App extends Application {
    /**
     * This class is used:
     * - For return an access to the application context from every part of the app.
     */

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        // Set up timber
        Timber.plant(new Timber.DebugTree());

        // Pre populate database
        DataGenerator.populateDatabase();

    }

    public static Context getContext(){
        /**
         * Be careful using this method only when you need the global application context. Do not use
         * it when you need a view context.
         */

        return App.context;
    }


}
