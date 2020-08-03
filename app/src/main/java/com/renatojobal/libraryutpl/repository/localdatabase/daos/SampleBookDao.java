package com.renatojobal.libraryutpl.repository.localdatabase.daos;

import androidx.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

import java.util.List;

/**
 * Dao for SampleBook Model
 */
@Dao
public interface SampleBookDao {

    @Query("SELECT * FROM "+ DBConstants.SAMPLE_BOOK_TABLE)
    LiveData<List<SampleBookModel>> getLiveDataList();

    @Insert
    void insert(SampleBookModel sampleBook);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplace(SampleBookModel sampleBook);

    @Query("DELETE FROM "+ DBConstants.SAMPLE_BOOK_TABLE)
    void deleteAll();

    @Delete
    void delete(SampleBookModel sampleBook);

}
