package com.renatojobal.libraryutpl.mainactivity.fhome;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.BookFull;
import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

import java.util.List;

/**
 * To access some data related with home fragment
 */
@Dao
public interface RecommendBooksDao {

    /**
     * @return books of result
     */
    @Query("SELECT * FROM "+ DBConstants.BOOK_INFO_TABLE)
    List<BookInfoModel> singleResultList();

}
