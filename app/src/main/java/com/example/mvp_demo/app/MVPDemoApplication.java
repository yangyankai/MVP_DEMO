package com.example.mvp_demo.app;

import android.app.Application;

import com.example.mvp_demo.util.volley.VolleyRequest;

/**
 * Created by Administrator on 2015/2/6.
 * 替换默认的Application实现
 */
public class MVPDemoApplication extends Application {
    private static MVPDemoApplication instance;

    public MVPDemoApplication() {
        instance = this;
    }

    public static Application getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyRequest.buildRequestQueue(this);
    }
}