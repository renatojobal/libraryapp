package com.renatojobal.libraryutpl.mainactivity.fhome;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import timber.log.Timber;

public class HomeViewModel extends ViewModel {
    /**
     * View model for home. I t will be an assistant between the repository and the view
     */

    private MutableLiveData<Boolean> shouldNavigateToSearch;


    public HomeViewModel() {
        /**
         * Empty constructor (We could use dagger in the future)
         */
        Timber.i("Home view-model attached");
        shouldNavigateToSearch = new MutableLiveData<>(Boolean.FALSE);

    }


    public void changeSearchClickedValue(Boolean value) {
        /**
         * This method will be called by the layout
         */
        this.shouldNavigateToSearch.setValue(value);
    }


    /**
     * Expose data to the fragment
     */
    public MutableLiveData<Boolean> getShouldNavigateToSearch(){
        return this.shouldNavigateToSearch;
    }

}
