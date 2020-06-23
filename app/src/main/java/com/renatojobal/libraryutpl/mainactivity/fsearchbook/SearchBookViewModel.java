package com.renatojobal.libraryutpl.mainactivity.fsearchbook;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.renatojobal.libraryutpl.repository.localdatabase.RoomHelper;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

import java.util.List;

/**
 * SearchBookViewModel
 */
public class SearchBookViewModel extends ViewModel {

    // List of books result
    private LiveData<List<SampleBookModel>> sampleBookResultList;

    // List of books result, here we use a view of the book: "BookFull" that allows us to
    // access more attributes from the book
    private LiveData<List<BookFull>> resultBookFullList;

    public String targetBook;

    private SearchBookPresenter searchBookPresenter;

    /**
     * Constructor
     */
    public SearchBookViewModel() {

        // We could use injection instead with the new Dagger HIlt library from android developers
        searchBookPresenter = new SearchBookPresenter();

        // Accessing the database using LiveData
        sampleBookResultList = RoomHelper.getAppDatabaseInstance().sampleBookDao().getLiveDataList();
        resultBookFullList = RoomHelper.getAppDatabaseInstance().resultDao().allResultLiveData();


    }


    /**
     * Exposing data to the view ---
     */

    /** Expose the result list*/
    public LiveData<List<SampleBookModel>> getSampleBookResultList() {
        return sampleBookResultList;
    }

    /** Expose the result list with full data */
    public LiveData<List<BookFull>> getResultBookFullList() {
        return resultBookFullList;
    }



    /**
     * UI interaction ---
     */
    /** Notify the fragment */
    public void setTargetBook(String query){
        // Do the request to the api and then storage it into the database
        searchBookPresenter.searchBook(query);

    }





}
