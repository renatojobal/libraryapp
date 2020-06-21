package com.renatojobal.libraryutpl.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.renatojobal.libraryutpl.mainactivity.fhome.HomePresenter;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.BookFull;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

import java.util.List;


public class MainViewModel extends AndroidViewModel {
    /**
     * Main view model for expose data that may would be expensive if we put them in each view model
     * for each fragment
     */

    private final MutableLiveData<Event<Integer>> newDestination = new MutableLiveData<>();


    private MutableLiveData<List<List<BookInfoModel>>> recommendedBooks = new MutableLiveData<>();



    HomePresenter homePresenter;

    public MainViewModel(@NonNull Application application) {
        super(application);

        homePresenter = new HomePresenter();

        homePresenter.getRecommendedBook(recommendedBooks);

        homePresenter.pullHomeContent();
    }


    public LiveData<Event<Integer>> getNewDestination() {
        return newDestination;
    }

    public void setNewDestination(int destinationId) {
        newDestination.setValue(new Event<>(destinationId));
    }

    public LiveData<List<List<BookInfoModel>>> getRecommendedBooks() {
        return recommendedBooks;
    }

}
