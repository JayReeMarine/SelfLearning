package com.fit2081.week4_lab30324181.provider;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
public class ApplicationRepository {
    private ApplicatioinDao mApplicationDao;
    private LiveData<List<application>> mAllApplication;

    ApplicationRepository(Application application) {
        ApplicationDatabase db = ApplicationDatabase.getDatabase(application);
        mApplicationDao = db.applicatioinDao();
        mAllApplication = mApplicationDao.getAllApplications();
    }
    LiveData<List<application>> getAllFleets() {
        return mAllApplication;
    }
    void insert(application application) {
        ApplicationDatabase.databaseWriteExecutor.execute(() -> mApplicationDao.AddApplication(application));
    }
}
