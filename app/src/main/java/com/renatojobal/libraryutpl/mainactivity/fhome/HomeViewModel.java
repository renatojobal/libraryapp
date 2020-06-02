package com.renatojobal.libraryutpl.mainactivity.fhome;

import androidx.lifecycle.ViewModel;

import timber.log.Timber;

public class HomeViewModel extends ViewModel {
    /**
     * View model for home. I t will be an assistant between the repository and the view
     */

    public HomeViewModel() {
        /**
         * Empty constructor (We could use dagger in the future)
         */
        Timber.i("Home view-model attached");
    }





}
