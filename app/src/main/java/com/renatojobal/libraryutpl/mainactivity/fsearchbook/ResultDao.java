package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ResultDao {
    // Lets access to the result of search a book from the database

    @Query("SELECT * FROM samplebookfull"
    )
    LiveData<List<SampleBookFull>> allResultLiveData();
}
