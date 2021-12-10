package com.aslam.aidl_server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyAIDLSERVER extends Service {

    public MyAIDLSERVER() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Aslam", "onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Return the interface
        Log.d("Aslam", "onBind");
        return binder;
    }


    private final ISum.Stub binder = new ISum.Stub() {
        @Override
        public int Sum(int a, int b) throws RemoteException {
            return a + b;
        }

        @Override
        public User getUser(int num) throws RemoteException {
            return new User(20 + num);
        }
    };
}