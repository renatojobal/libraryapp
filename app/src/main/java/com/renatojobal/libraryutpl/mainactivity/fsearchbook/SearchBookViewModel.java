package com.renatojobal.libraryutpl.mainactivity.fsearchbook;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

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

    public String targetBook;

    public SearchBookViewModel() {

        sampleBookResultList = RoomHelper.getAppDatabaseInstance().sampleBookDao().getLiveDataList();


    }

    public LiveData<List<SampleBookModel>> getSampleBookResultList() {
        /** Expose the result list*/
        return sampleBookResultList;
    }


    // UI interaction
    public void setTargetBook(String query){
        /**
         * Notify the fragment
         */
        // TODO: Do the request to the api and then storage it into the database

    }





}
