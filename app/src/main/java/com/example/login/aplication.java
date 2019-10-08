package com.example.login;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class aplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
