package com.example.fatimamostafa.roomarchitecture;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by fatimamostafa on 11/26/17.
 */

public class MetricsListViewModel extends AndroidViewModel {

    private final LiveData<List<MetricsModel>> itemAndMetricsList;

    private AppDatabase appDatabase;

    public MetricsListViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
        itemAndMetricsList = appDatabase.itemAndMetricsModel().getAllMetricsList();
    }

    public LiveData<List<MetricsModel>> getItemAndMetricsList() {
        return itemAndMetricsList;
    }

    public void deleteItem(MetricsModel metricsModel) {
        new deleteAsyncTask(appDatabase).execute(metricsModel);
    }

    public void addItem(MetricsModel metricsModel) {
        new addAsyncTask(appDatabase).execute(metricsModel);
    }


    private static class deleteAsyncTask extends AsyncTask<MetricsModel, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final MetricsModel... params) {
            db.itemAndMetricsModel().deleteItem(params[0]);
            return null;
        }


    }
    private static class addAsyncTask extends AsyncTask<MetricsModel, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final MetricsModel... params) {
            db.itemAndMetricsModel().addItem(params[0]);
            return null;
        }

    }


}