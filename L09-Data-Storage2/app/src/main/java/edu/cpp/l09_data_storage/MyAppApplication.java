package edu.cpp.l09_data_storage;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

import io.paperdb.Paper;

/**
 * Created by yusun on 5/1/17.
 */

public class MyAppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ActiveAndroid.initialize(this);
        Paper.init(this);
    }
}
