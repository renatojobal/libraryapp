package com.renatojobal.libraryutpl.repository.localdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.renatojobal.libraryutpl.mainactivity.fhome.RecommendBooksDao;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.ResultDao;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.BookFull;
import com.renatojobal.libraryutpl.repository.localdatabase.converter.DateConverter;
import com.renatojobal.libraryutpl.repository.localdatabase.daos.AuthorDao;
import com.renatojobal.libraryutpl.repository.localdatabase.daos.BookInfoDao;
import com.renatojobal.libraryutpl.repository.localdatabase.daos.SampleBookDao;
import com.renatojobal.libraryutpl.repository.localdatabase.daos.ShelfDao;
import com.renatojobal.libraryutpl.repository.model.AuthorModel;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;

/**
 * This class expose the database data access objects (DAOs)
 */
@Database(
        entities = {
                BookInfoModel.class,
                SampleBookModel.class,
                ShelfModel.class,
                AuthorModel.class
        },
        views = {
                BookFull.class
        },
        exportSchema = true,
        version = 16)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract BookInfoDao bookInfoDao();

    public abstract SampleBookDao sampleBookDao();

    public abstract ShelfDao shelfDao();

    public abstract AuthorDao authorDao();

    public abstract ResultDao resultDao();

    public abstract RecommendBooksDao recommendBooksDao();

}
