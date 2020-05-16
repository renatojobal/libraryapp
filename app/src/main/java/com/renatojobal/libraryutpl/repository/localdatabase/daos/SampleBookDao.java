package com.renatojobal.libraryutpl.repository.localdatabase.daos;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

import java.util.List;


@Dao
public interface SampleBookDao {

    @Query("SELECT * FROM samplebookmodel")
    DataSource.Factory<Integer, SampleBookModel> getLiveDataPagedList();

    @Query("SELECT * FROM samplebookmodel")
    LiveData<List<SampleBookModel>> getLiveDataList();

    @Insert
    void insert(SampleBookModel sampleBook);

    @Query("DELETE FROM samplebookmodel")
    void deleteAll();

    @Delete
    void delete(SampleBookModel sampleBook);

}
