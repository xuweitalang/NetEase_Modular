package com.netease.modular.order.debug;

import android.util.Log;

import com.netease.common.base.BaseApplication;
import com.netease.common.constant.Cons;
import com.netease.modular.order.BuildConfig;

public class Order_DebugApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(Cons.TAG, "order/debug/Order_DebugApplication");
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
