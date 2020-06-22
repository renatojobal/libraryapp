package com.renatojobal.libraryutpl.mainactivity.fhome;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.BookFull;
import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

import java.util.List;

@Dao
public interface RecommendBooksDao {

    @Query("SELECT * FROM "+ DBConstants.BOOK_INFO_TABLE)
    List<BookInfoModel> singleResultList();

}
