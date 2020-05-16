package com.renatojobal.libraryutpl.mainactivity.fsearchbook;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.renatojobal.libraryutpl.repository.localdatabase.RoomHelper;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;



public class SearchBookViewModel extends ViewModel {
    /**
     * SearchBookViewModel
     *
     * @param sampleBookList list of books found
     */

    private LiveData<PagedList<SampleBookModel>> sampleBookResultList;

    // Data source
    DataSource.Factory<Integer, SampleBookModel> myResultDataSource;

    public SearchBookViewModel() {

        myResultDataSource =
                RoomHelper.getAppDatabaseInstance().sampleBookDao().getLiveDataPagedList();

        sampleBookResultList =
                new LivePagedListBuilder<Integer, SampleBookModel>(
                RoomHelper.getAppDatabaseInstance().sampleBookDao().getLiveDataPagedList(),
                20)
                .build();
    }



}
