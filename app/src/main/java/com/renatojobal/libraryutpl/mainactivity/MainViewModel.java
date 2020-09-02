package com.renatojobal.libraryutpl.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.renatojobal.libraryutpl.mainactivity.fhome.HomePresenter;
import com.renatojobal.libraryutpl.mainactivity.util.Event;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

import java.util.List;

import timber.log.Timber;

/**
 * Main view model for expose data that may would be expensive if we put them in each view model
 * for each fragment
 */
public class MainViewModel extends AndroidViewModel {


    // To show the books in the home screen
    // We put this variable here instead in the properly fragment view model
    // because we do not want to be updating this info every time when the fragment onResume(),
    // we only update this info when the activity start.
    private MutableLiveData<List<List<BookInfoModel>>> recommendedBooks = new MutableLiveData<>();

    private MutableLiveData<BookInfoModel> focusBook = new MutableLiveData<>();

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


    }



    /**
     * Method called by the home fragment
     * @return recommendedBooks
     */
    public LiveData<List<List<BookInfoModel>>> getRecommendedBooks() {
        return recommendedBooks;
    }

    public void setFocusBook(BookInfoModel focusBook){
        Timber.d("Setting a new book: %s", focusBook);
        this.focusBook.setValue(focusBook);
    }

    public LiveData<BookInfoModel> getFocusBook(){
        return this.focusBook;
    }



}
