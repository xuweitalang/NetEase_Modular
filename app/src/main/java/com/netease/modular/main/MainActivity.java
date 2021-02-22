package com.netease.modular;

import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.netease.common.base.mvc.BaseMvpActivity;
import com.netease.common.constant.Cons;
import com.netease.common.constant.RoutePath;

public class MainActivity extends BaseMvpActivity<com.netease.modular.databinding.ActivityMainBinding, MainContract.View, MainContract.Presenter> {

    @Override
    protected void initData() {
        if (BuildConfig.isRelease) {
            Log.e(Cons.TAG, "当前为：集成化模式，除app可运行，其他子模块都是Android Library");
        } else {
            Log.e(Cons.TAG, "当前为：组件化模式，app/order/personal子模块都可独立运行");
        }
    }

    @Override
    protected MainContract.Presenter createPresenter() {
        return null;
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
