package com.renatojobal.libraryutpl.repository.localdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.renatojobal.libraryutpl.repository.localdatabase.converter.DateConverter;
import com.renatojobal.libraryutpl.repository.localdatabase.daos.SampleBookDao;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

@Database(entities = {
        SampleBookModel.class
},
        version = 1)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    /**
     * Database
     */

    public abstract SampleBookDao sampleBookDao();

}
