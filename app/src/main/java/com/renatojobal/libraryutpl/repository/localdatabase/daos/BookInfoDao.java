package com.renatojobal.libraryutpl.repository.localdatabase.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

@Dao
public interface BookInfoDao {
    /**
     * Dao for BookInfo Model
     * @return
     */

    @Insert
    void insert(BookInfoModel bookInfo);

    @Delete
    void delete(BookInfoModel bookInfo);

    @Query("DELETE FROM "+ DBConstants.BOOK_INFO_TABLE)
    void deleteAll();
}
