package com.netease.modular.order.debug;

import android.view.View;
import android.widget.Toast;

import com.netease.common.base.BaseActivity;
import com.netease.modular.order.databinding.OrderActivityDebugBinding;

public class Order_DebugActivity extends BaseActivity<OrderActivityDebugBinding> {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.order_activity_debug);
//
//        Log.e(Cons.TAG, "order/debug/Order_DebugActivity");
//    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        viewBinding.tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Order_DebugActivity.this, viewBinding.tvTest.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void start() {

    }
}
