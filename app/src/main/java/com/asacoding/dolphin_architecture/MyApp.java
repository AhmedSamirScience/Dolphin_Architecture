package com.asacoding.dolphin_architecture;

import android.app.Application;
import android.content.Context;


import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyApp extends Application {
    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();

    }
}
