package com.renatojobal.libraryutpl.repository.localdatabase.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

import java.util.List;

/**
 * Dao for BookInfo Model
 */
@Dao
public interface BookInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplace(BookInfoModel bookInfo);

    @Insert
    void insert(BookInfoModel bookInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllOrReplace(List<BookInfoModel> bookInfoModelList);

    @Query("SELECT * FROM "+DBConstants.BOOK_INFO_TABLE+" WHERE "+DBConstants.BOOK_INFO_ID+" = :id")
    BookInfoModel getBookInfo(int id);

    @Delete
    void delete(BookInfoModel bookInfo);

    @Query("DELETE FROM "+ DBConstants.BOOK_INFO_TABLE)
    void deleteAll();
}
