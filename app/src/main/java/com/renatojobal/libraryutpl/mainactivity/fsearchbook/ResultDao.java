package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ResultDao {
    // Lets access to the result of search a book from the database

    @Query("SELECT * FROM ResultView")
    List<ResultView> allResultLiveData();
}
