package com.netease.modular.personal;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.netease.common.base.BaseActivity;
import com.netease.common.constant.Cons;
import com.netease.common.constant.RoutePath;

@Route(path = RoutePath.ROUTE_PERSON_MAIN)
public class Personal_MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);
        Log.e(Cons.TAG, "personal/Personal_MainActivity");
    }
}
