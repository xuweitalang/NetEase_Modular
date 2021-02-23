package com.netease.modular.demo.debug;

import android.widget.Toast;

import com.netease.common.base.BaseActivity;
import com.netease.modular.demo.databinding.DemoActivityDebugBinding;

public class Demo_DebugActivity extends BaseActivity<DemoActivityDebugBinding> {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        viewBinding.tvTest.setOnClickListener(v -> Toast.makeText(Demo_DebugActivity.this, viewBinding.tvTest.getText().toString(), Toast.LENGTH_LONG).show());
    }

    @Override
    protected void start() {

    }
}
