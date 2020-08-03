package com.renatojobal.libraryutpl;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.renatojobal.libraryutpl.mainactivity.timber.DebugTree;
import com.renatojobal.libraryutpl.mainactivity.timber.ReleaseTree;
import com.renatojobal.libraryutpl.repository.localdatabase.DataGenerator;

import timber.log.Timber;

/**
 * Main class that will be initialize when the app is open
 * This class is used:
 * - For return an access to the application context from every part of the app.
 * - Setup Timber (Used for logging)
 */
public class App extends Application {


    private static Context context;

    /**
     * Method called when the app is open
     */
    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();

        // Set up timber
        setUpTimber();

        // Pre populate database (if needed)
        DataGenerator.populateDatabase();

    }

    /**
     * Be careful using this method only when you need the global application context. Do not use
     * it when you need a view context.
     * @return
     */
    public static Context getContext(){

        return App.context;
    }



    /**
     * Timber is a library to log in a better way
     */
    private void setUpTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
            // Set a key to an int.
            // FirebaseCrashlytics.getInstance().setCustomKey("Build config", "DEBUG");
            Timber.i("Timber set up in DEBUG level");
        } else {
            Timber.plant(new ReleaseTree());
            // Set a key to an int.
            // FirebaseCrashlytics.getInstance().setCustomKey("Build config", "RELEASE");
        }

    }


}
