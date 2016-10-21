package com.sunsmart.cardlist;

import android.app.Application;

import daogenerator.DaoHelper;

/**
 * Created by yzs on 2016/10/20.
 */

public class CaredApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DaoHelper.initDatabase(this);
    }
}
