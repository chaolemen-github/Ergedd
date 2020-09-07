package com.chaolemen.ergedd.app;

import android.app.Application;

import com.chaolemen.ergedd.interceptor.CookieInterceptor;
import com.chaolemen.httplibrary.HttpGlobalConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;

public class BaseApp extends Application {

    private static BaseApp app;

    public static BaseApp getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;

        //拦截器
        ArrayList<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new CookieInterceptor());

        //请求头
        HashMap<String, Object> headerMap = new HashMap<>();
        headerMap.put("Cache-Control","public");
        headerMap.put("max-age",28800);

        HttpGlobalConfig.getInsance()
                .setBaseUrl("http://api.ergedd.com/")
                .setTimeout(10)
                .setBaseHeades(headerMap)
                .setInterceptors(interceptors)
                .setTimeUnit(TimeUnit.SECONDS)
                .setShowLog(true)
                .initReady(this);
    }
}
