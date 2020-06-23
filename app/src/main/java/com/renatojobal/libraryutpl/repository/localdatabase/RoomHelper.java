package com.renatojobal.libraryutpl.repository.localdatabase;

import androidx.room.Room;

import com.renatojobal.libraryutpl.App;

/**
 * This class provide a singleton of RoomDatabase
 */
public class RoomHelper {

    private static final AppDatabase sAppDatabase = Room.databaseBuilder(App.getContext(), AppDatabase.class, DBConstants.DATABASE_NAME)
                  .allowMainThreadQueries()   // Is dangerous to the UX using Room in the main thread. It is very time expensive
            .fallbackToDestructiveMigration()
            .build();


    /**
     * Expose the singleton app database
     * @return sAppDatabase
     */
    public static AppDatabase getAppDatabaseInstance(){
        return sAppDatabase;
    }




}
