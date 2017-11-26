package com.example.fatimamostafa.roomarchitecture;

/**
 * Created by fatimamostafa on 11/26/17.
 */

import android.arch.persistence.room.TypeConverter;

import java.util.Date;
class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}