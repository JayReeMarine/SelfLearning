package com.fit2081.week4_lab30324181.provider;

public class DeviceFeature {
    String featureName;
    int sortOrder;

    public DeviceFeature(String featureName, int sortOrder){
        this.featureName=featureName;
        this.sortOrder=sortOrder;
    }

    public String getFeatureName(){return featureName;}
    public int getSortOrder(){return sortOrder;}
}
