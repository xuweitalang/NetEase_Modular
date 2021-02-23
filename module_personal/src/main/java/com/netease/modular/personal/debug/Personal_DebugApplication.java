package com.netease.modular.personal.debug;

import android.util.Log;

import com.netease.common.base.BaseApplication;
import com.netease.common.constant.Cons;
import com.netease.modular.personal.BuildConfig;

public class Personal_DebugApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(Cons.TAG, "personal/debug/Personal_DebugApplication");
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
