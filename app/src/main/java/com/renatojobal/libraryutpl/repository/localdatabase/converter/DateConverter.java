package com.renatojobal.libraryutpl.repository.localdatabase.converter;

import androidx.room.TypeConverter;

import java.util.Date;

/**
 * This class is used only for convert date to timestamp and solve some problems
 */
public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}