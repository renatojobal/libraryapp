package com.renatojobal.libraryutpl;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class App extends Application {
    /**
     * This class is used:
     * - For return an access to the application context from every part of the app.
     */
    private static final String TAG = "App";

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();

        // Set up timber

    }

    public static Context getContext(){
        /**
         * Be careful using this method only when you need the global application context. Do not use
         * it when you need a view context.
         */

        return App.context;
    }


}
