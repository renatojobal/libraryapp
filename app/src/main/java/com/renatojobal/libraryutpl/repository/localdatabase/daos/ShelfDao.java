package com.renatojobal.libraryutpl.repository.localdatabase.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;

/**
 * Dao for Shelf model
 */
@Dao
public interface ShelfDao {

    @Insert
    void insert(ShelfModel shelf);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplace(ShelfModel shelf);

    @Delete
    void delete(ShelfModel shelf);

    @Query("DELETE FROM "+ DBConstants.SHELF_TABLE)
    void deleteAll();
}
