package com.renatojobal.libraryutpl.repository.localdatabase;



import androidx.room.Room;
import androidx.room.RoomDatabase.Builder;

import com.renatojobal.libraryutpl.App;

public class RoomHelper {
    /**
     * This class provide a singleton of RoomDatabase
     */

    private static AppDatabase sAppDatabase;

    private static final Builder builder = Room.databaseBuilder(App.getContext(), AppDatabase.class, DatabaseConstants.DATABASE_NAME)
            //      .allowMainThreadQueries()   This was removed because is dangerous to the UX using Room in the main thread. It is very time expensive
            .fallbackToDestructiveMigration();


    public static void buildDatabase(Builder builder){
        builder.build();
    }

    public static AppDatabase getAppDatabaseInstance(){
        if(sAppDatabase == null){
            buildDatabase(builder);
        }

        return sAppDatabase;
    }




}
