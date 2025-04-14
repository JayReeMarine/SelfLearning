package com.fit2081.week4_lab30324181.provider;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class ApplicationViewModel extends AndroidViewModel {
    private ApplicationRepository mRepo;
    private LiveData<List<application>> mAllApplications;

    public ApplicationViewModel(@NonNull Application application) {
        super(application);
        mRepo = new ApplicationRepository(application);
        mAllApplications = mRepo.getAllFleets();
    }

    public LiveData<List<application>> getAllFleets() {
        return mAllApplications;
    }

    public void insert(application fleet) {
        mRepo.insert(fleet);
    }

}
