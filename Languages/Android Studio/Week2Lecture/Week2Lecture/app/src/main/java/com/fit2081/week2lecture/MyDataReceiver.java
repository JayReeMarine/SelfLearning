package com.fit2081.week2lecture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyDataReceiver extends BroadcastReceiver {

   private static ISendData instance;

    public static void bindInstance(ISendData anInstance){
        instance=anInstance;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String myData=intent.getExtras().getString(Keys.BC_KEY);
        int counter=intent.getExtras().getInt(Keys.COUNTER_KEY);
        instance.processData(myData);
        Log.d(MainActivity.TAG,"the received is :-"+myData);
        // can I update my UI from HERE

    }
}