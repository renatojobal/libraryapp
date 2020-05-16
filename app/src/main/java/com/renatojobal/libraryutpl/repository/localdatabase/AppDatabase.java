package com.renatojobal.libraryutpl.repository.localdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.renatojobal.libraryutpl.repository.localdatabase.converter.DateConverter;
import com.renatojobal.libraryutpl.repository.localdatabase.daos.SampleBookDao;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;

@Database(entities = {
        BookInfoModel.class,
        SampleBookModel.class,
        ShelfModel.class
},
        version = 2)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    /**
     * Database
     */

    public abstract SampleBookDao sampleBookDao();


}
