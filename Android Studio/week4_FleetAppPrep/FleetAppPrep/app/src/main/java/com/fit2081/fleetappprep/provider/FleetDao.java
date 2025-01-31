package com.fit2081.fleetappprep.provider;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FleetDao {

    @Insert
    void AddFleet(Fleet fleet);

    @Query("select * from fleets")
    LiveData<List<Fleet>> getAllFleets();
}
