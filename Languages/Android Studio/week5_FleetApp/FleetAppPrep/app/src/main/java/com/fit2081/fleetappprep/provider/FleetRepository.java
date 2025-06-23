package com.fit2081.fleetappprep.provider;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FleetRepository {

    private FleetDao mFleetDao;
    private LiveData<List<Fleet>> mAllFleet;

    FleetRepository(Application application) {
        FleetDatabase db = FleetDatabase.getDatabase(application);
        mFleetDao = db.fleetDao();
        mAllFleet = mFleetDao.getAllFleets();
    }

    LiveData<List<Fleet>> getAllFleets() {
        return mAllFleet;
    }

    void insert(Fleet fleet) {
        FleetDatabase.databaseWriteExecutor.execute(() -> mFleetDao.AddFleet(fleet));
    }

    int deleteFleet(int id) {
        FleetDatabase.databaseWriteExecutor.execute(() -> {
            mFleetDao.deleteFleetById(id);
        });
        return 1;
    }
}
