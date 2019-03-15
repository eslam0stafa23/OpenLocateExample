package com.example.openlocateexample;

import android.app.Application;

import com.openlocate.android.core.OpenLocate;

import java.util.HashMap;

public class Init extends Application {

    public static Init getInstance() {
        return new Init();
    }

    @Override
    public void onCreate(){
        super.onCreate();

        OpenLocate.Configuration configuration = new OpenLocate.Configuration.Builder(this, "https://openlocateexample.firebaseio.com/.json")
                .setHeaders(getHeaderParams())
                .build();

        OpenLocate.initialize(configuration);
    }

    public HashMap<String, String> getHeaderParams () {
        HashMap<String, String> params = new HashMap<>();
        params.put("Content-Type", "application/json");
        return params;
    }
}
