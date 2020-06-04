package com.renatojobal.libraryutpl.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;




public class MainViewModel extends AndroidViewModel {
    /**
     * Main view model for expose data that may would be expensive if we put them in each view model
     * for each fragment
     */

    private final MutableLiveData<Event<Integer>> newDestination = new MutableLiveData<>();


    public MainViewModel(@NonNull Application application) {
        super(application);



    }


    public LiveData<Event<Integer>> getNewDestination() {
        return newDestination;
    }

    public void setNewDestination(int destinationId) {
        newDestination.setValue(new Event<>(destinationId));
    }



}
