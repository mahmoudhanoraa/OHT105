package com.hanora.mahmoud.oht105.FireBase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by echessa on 3/10/16.
 */
public class OHApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }

}