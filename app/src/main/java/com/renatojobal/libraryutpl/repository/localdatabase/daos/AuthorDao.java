package com.renatojobal.libraryutpl.repository.localdatabase.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;
import com.renatojobal.libraryutpl.repository.model.AuthorModel;

@Dao
public interface AuthorDao {
    /**
     * Dao for Author model
     * @return
     */

    @Insert
    void insert(AuthorModel author);

    @Delete
    void delete(AuthorModel model);

    @Query("DELETE FROM "+ DBConstants.AUTHOR_TABLE)
    void deleteAll();


}
