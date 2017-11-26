package com.example.fatimamostafa.roomarchitecture;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created by fatimamostafa on 11/26/17.
 */

@Entity   //database table
public class MetricsModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String metricsTitle;
    private String metricsValue;

    @TypeConverters(DateConverter.class)
    private Date borrowDate;

    public MetricsModel(String metricsTitle, String metricsValue, Date borrowDate) {
        this.metricsTitle = metricsTitle;
        this.metricsValue = metricsValue;
        this.borrowDate = borrowDate;
    }

    public String getMetricsTitle() {
        return metricsTitle;
    }

    public void setMetricsTitle(String metricsTitle) {
        this.metricsTitle = metricsTitle;
    }

    public String getMetricsValue() {
        return metricsValue;
    }

    public void setMetricsValue(String metricsValue) {
        this.metricsValue = metricsValue;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}
