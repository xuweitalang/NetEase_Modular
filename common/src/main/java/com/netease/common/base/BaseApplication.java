package com.netease.common.base;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.netease.common.app.AppState;
import com.squareup.leakcanary.LeakCanary;

/**
 * 项目父Application
 */
public abstract class BaseApplication extends Application {
    private static final String TAG = "BaseApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        AppState.getInstance().init(this);
        if (isDebug()) {
            initLeakCanary();
        }
        initRouter();
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            Log.d(TAG, "LeakCanary process is starting for heap analysis");
            return;
        }
        LeakCanary.refWatcher(this).buildAndInstall();
    }

    private void initRouter() {
        if (isDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    public abstract boolean isDebug();
}
