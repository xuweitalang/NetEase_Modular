package com.netease.modular.order;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.netease.common.base.BaseActivity;
import com.netease.common.constant.Cons;
import com.netease.common.constant.RoutePath;

@Route(path = RoutePath.ROUTE_ORDER_MAIN)
public class Order_MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);

        Log.e(Cons.TAG, "order/Order_MainActivity");
    }
}
