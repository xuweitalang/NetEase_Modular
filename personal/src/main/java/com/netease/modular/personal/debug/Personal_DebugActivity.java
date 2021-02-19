package com.netease.modular.personal.debug;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.netease.common.base.BaseActivity;
import com.netease.common.constant.Cons;
import com.netease.modular.personal.Personal_MainActivity;
import com.netease.modular.personal.R;

public class Personal_DebugActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_debug);

        Log.e(Cons.TAG, "personal/debug/Personal_DebugActivity");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void start() {

    }

    public void jump(View view) {
        startActivity(new Intent(this, Personal_MainActivity.class));
    }
}
