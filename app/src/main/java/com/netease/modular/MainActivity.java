package com.netease.modular;

import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.netease.common.base.BaseActivity;
import com.netease.common.constant.Cons;
import com.netease.common.constant.RoutePath;
import com.netease.modular.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void initData() {
        if (BuildConfig.isRelease) {
            Log.e(Cons.TAG, "当前为：集成化模式，除app可运行，其他子模块都是Android Library");
        } else {
            Log.e(Cons.TAG, "当前为：组件化模式，app/order/personal子模块都可独立运行");
        }
    }

    @Override
    protected void initView() {
        viewBinding.btnOrder.setOnClickListener(v -> ARouter.getInstance().build(RoutePath.ROUTE_ORDER_MAIN).navigation());
        viewBinding.btnDemo.setOnClickListener(v -> ARouter.getInstance().build(RoutePath.ROUTE_DEMO_MAIN).navigation());
    }

    @Override
    protected void start() {

    }
}
