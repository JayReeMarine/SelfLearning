package com.fit2081.fleetappprep.provider;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FleetViewModel extends AndroidViewModel {

    private FleetRepository mRepo;
    private LiveData<List<Fleet>> mAllFleets;

    public FleetViewModel(@NonNull Application application) {
        super(application);
        mRepo = new FleetRepository(application);
        mAllFleets = mRepo.getAllFleets();
    }

    public LiveData<List<Fleet>> getAllFleets() {
        return mAllFleets;
    }

    public void insert(Fleet fleet) {
        mRepo.insert(fleet);
    }

    public int deleteFleet(int id) {
        return mRepo.deleteFleet(id);
    }


}
