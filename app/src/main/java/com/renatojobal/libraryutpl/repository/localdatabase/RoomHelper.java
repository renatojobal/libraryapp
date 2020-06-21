package com.renatojobal.libraryutpl.repository.localdatabase;

import androidx.room.Room;

import com.renatojobal.libraryutpl.App;

public class RoomHelper {
    /**
     * This class provide a singleton of RoomDatabase
     */

    private static final AppDatabase sAppDatabase = Room.databaseBuilder(App.getContext(), AppDatabase.class, DBConstants.DATABASE_NAME)
                  .allowMainThreadQueries()   // Is dangerous to the UX using Room in the main thread. It is very time expensive
            .fallbackToDestructiveMigration()
            .build();



    public static AppDatabase getAppDatabaseInstance(){
        return sAppDatabase;
    }




}
