package com.renatojobal.libraryutpl.mainactivity.fsearchbook

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ResultDao {

    @Query(
            """
                SELECT * FROM SampleBookFull
            """
    )
    abstract fun allResultLiveData() : LiveData<List<SampleBookFull>>
}