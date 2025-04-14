package com.fit2081.week4_lab30324181.provider;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ApplicatioinDao {
    @Insert
    void AddApplication(application application);

    @Query("select * from applications")
    LiveData<List<application>> getAllApplications();
}
