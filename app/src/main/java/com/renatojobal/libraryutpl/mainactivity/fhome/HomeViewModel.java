package com.renatojobal.libraryutpl.mainactivity.fhome;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import timber.log.Timber;

/**
 * View model for home. I t will be an assistant between the repository and the view
 */
public class HomeViewModel extends ViewModel {


    private MutableLiveData<Boolean> shouldNavigateToSearch;


    /**
     * Empty constructor (We could use dagger in the future)
     */
    public HomeViewModel() {

        Timber.i("Home view-model attached");
        shouldNavigateToSearch = new MutableLiveData<>(Boolean.FALSE);

    }


    /**
     * This method will be called by the layout
     */
    public void changeSearchClickedValue(Boolean value) {

        this.shouldNavigateToSearch.setValue(value);
    }


    /**
     * Expose data to the fragment
     */
    public MutableLiveData<Boolean> getShouldNavigateToSearch(){
        return this.shouldNavigateToSearch;
    }

}
