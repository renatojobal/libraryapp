package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

/**
 * Dao for the result
 */
@Dao
public interface ResultDao {

    // Lets access to the result of search a book from the database
    // BookFull is a view table
    @Query("SELECT * FROM BookFull")
    LiveData<List<BookFull>> allResultLiveData();
}
