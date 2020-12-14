package com.example.mybusiness;

import android.app.Application;

public class MyAplicaction extends Application {
    private static com.example.mybusiness.MyAplicaction instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static com.example.mybusiness.MyAplicaction getInstance(){
        return instance;
    }
}
