package com.example.fatimamostafa.roomarchitecture;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by fatimamostafa on 11/26/17.
 */

@Database(entities = {MetricsModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "metrics_db")
                            .build();
        }
        return INSTANCE;
    }

    public abstract MetricsModelDao itemAndMetricsModel();

}
