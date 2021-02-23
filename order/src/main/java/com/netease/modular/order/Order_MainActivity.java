package com.netease.modular.order;

import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.netease.common.base.BaseActivity;
import com.netease.common.constant.RoutePath;
import com.netease.modular.order.databinding.OrderActivityMainBinding;

@Route(path = RoutePath.ROUTE_ORDER_MAIN)
public class Order_MainActivity extends BaseActivity<OrderActivityMainBinding> {
    private static final String TAG = "Order_MainActivity";
    //获取ARouter传递的参数
    @Autowired
    public String test;

    @Override
    protected void initData() {
        viewBinding.tvTest.setText(test == null ? "null" : test);
        Log.d(TAG, "test = " + test);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void start() {

    }
}
