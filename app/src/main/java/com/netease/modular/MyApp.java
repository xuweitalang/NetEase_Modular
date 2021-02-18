package com.netease.modular;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Author: xuwei
 * @Date: 2021/2/7 10:49
 * @Description:
 */
class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
    }

    private void initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

}
