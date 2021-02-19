package com.netease.modular;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.netease.common.base.BaseApplication;

/**
 * @Author: xuwei
 * @Date: 2021/2/7 10:49
 * @Description:
 */
public class MyApp extends BaseApplication {

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

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }


}
