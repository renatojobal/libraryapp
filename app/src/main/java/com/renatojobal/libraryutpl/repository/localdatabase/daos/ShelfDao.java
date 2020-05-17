package com.renatojobal.libraryutpl.repository.localdatabase.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.renatojobal.libraryutpl.repository.model.ShelfModel;

@Dao
public interface ShelfDao {
    /**
     * Dao for Shelf model
     * @return
     */

    @Insert
    void insert(ShelfModel shelf);

    @Delete
    void delete(ShelfModel shelf);

    @Query("DELETE FROM shelfmodel")
    void deleteAll();
}
