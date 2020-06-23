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

/**
 * Main view model for expose data that may would be expensive if we put them in each view model
 * for each fragment
 */
public class MainViewModel extends AndroidViewModel {

    // To know which activity we have to navigate to
    private final MutableLiveData<Event<Integer>> newDestination = new MutableLiveData<>();

    // To show the books in the home screen
    // We put this variable here instead in the properly fragment view model
    // because we do not want to be updating this info every time when the fragment onResume(),
    // we only update this info when the activity start.
    private MutableLiveData<List<List<BookInfoModel>>> recommendedBooks = new MutableLiveData<>();

    // Instance that will help this view model doing some home fragment stuff
    HomePresenter homePresenter;

    /**
     * Constructor
     * @param application (This params is provided as default)
     */
    public MainViewModel(@NonNull Application application) {
        super(application);

        homePresenter = new HomePresenter();

        homePresenter.getRecommendedBook(recommendedBooks);

        homePresenter.pullHomeContent();
    }


    /**
     * Expose the destination
     * @return newDestination
     */
    public LiveData<Event<Integer>> getNewDestination() {
        return newDestination;
    }

    /**
     * Method called inside the fragments and will trigger a navigation to the new destination
     * @param destinationId
     */
    public void setNewDestination(int destinationId) {
        newDestination.setValue(new Event<>(destinationId));
    }

    /**
     * Method called by the home fragment
     * @return recommendedBooks
     */
    public LiveData<List<List<BookInfoModel>>> getRecommendedBooks() {
        return recommendedBooks;
    }

}
