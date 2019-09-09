package com.xhb.androidoservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Will crash on Android O
 *
 * Error -->
 * android.app.RemoteServiceException: Context.startForegroundService() did not then call Service.startForeground()
 */
public class EmptyService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
