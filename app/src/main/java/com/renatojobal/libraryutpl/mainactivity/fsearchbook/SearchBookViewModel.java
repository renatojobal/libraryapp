package com.renatojobal.libraryutpl.mainactivity.fsearchbook;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.renatojobal.libraryutpl.repository.localdatabase.RoomHelper;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

import java.util.List;


public class SearchBookViewModel extends ViewModel {
    /**
     * SearchBookViewModel
     *
     * @param sampleBookList list of books found
     */
    private static final String TAG = "SearchBookViewModel";

    private LiveData<List<SampleBookModel>> sampleBookResultList;
    private LiveData<List<ResultView>> sampleBookFullList;

    public String targetBook;

    private SearchBookPresenter searchBookPresenter;

    public SearchBookViewModel() {

        // We could use injection instead
        searchBookPresenter = new SearchBookPresenter();


        sampleBookResultList = RoomHelper.getAppDatabaseInstance().sampleBookDao().getLiveDataList();
        sampleBookFullList = RoomHelper.getAppDatabaseInstance().resultDao().allResultLiveData();


    }


    /**
     * Exposing data to the view ---
     */

    public LiveData<List<SampleBookModel>> getSampleBookResultList() {
        /** Expose the result list*/
        return sampleBookResultList;
    }

    public LiveData<List<ResultView>> getSampleBookFullList() {
        /** EExpose the result list with full data */
        return sampleBookFullList;
    }





    /**
     * UI interaction ---
     */

    public void setTargetBook(String query){
        /**
         * Notify the fragment
         */
        // Do the request to the api and then storage it into the database
        searchBookPresenter.searchBook(query);

    }





}
