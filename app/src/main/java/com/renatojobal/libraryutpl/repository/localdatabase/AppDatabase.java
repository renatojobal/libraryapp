package com.renatojobal.libraryutpl.repository.localdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.ResultDao;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.ResultView;
import com.renatojobal.libraryutpl.repository.localdatabase.converter.DateConverter;
import com.renatojobal.libraryutpl.repository.localdatabase.daos.AuthorDao;
import com.renatojobal.libraryutpl.repository.localdatabase.daos.BookInfoDao;
import com.renatojobal.libraryutpl.repository.localdatabase.daos.SampleBookDao;
import com.renatojobal.libraryutpl.repository.localdatabase.daos.ShelfDao;
import com.renatojobal.libraryutpl.repository.model.AuthorModel;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;

@Database(
        entities = {
                BookInfoModel.class,
                SampleBookModel.class,
                ShelfModel.class,
                AuthorModel.class
        },
        views = {
                ResultView.class
        },
        exportSchema = true,
        version = 10)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    /**
     * Expose the database data access objects
     */

    public abstract BookInfoDao bookInfoDao();

    public abstract SampleBookDao sampleBookDao();

    public abstract ShelfDao shelfDao();

    public abstract AuthorDao authorDao();


    public abstract ResultDao resultDao();

}
