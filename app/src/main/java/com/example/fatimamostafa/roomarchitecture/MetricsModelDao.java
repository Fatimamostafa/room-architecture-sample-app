package com.example.fatimamostafa.roomarchitecture;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by fatimamostafa on 11/26/17.
 */

@Dao
@TypeConverters(DateConverter.class)
public interface MetricsModelDao {

    @Query("SELECT * FROM MetricsModel")
    LiveData<List<MetricsModel>> getAllMetricsList();

    @Query("SELECT * FROM MetricsModel WHERE id = :id")
    MetricsModel getItemById(String id);

    @Insert(onConflict = REPLACE)
    void addItem(MetricsModel metricsModel);

    @Delete
    void deleteItem(MetricsModel metricsModel);



}
