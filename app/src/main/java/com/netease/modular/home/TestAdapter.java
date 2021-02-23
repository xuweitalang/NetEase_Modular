package com.netease.modular.home;

import android.content.Context;

import com.netease.common.base.BaseAdapter;
import com.netease.modular.databinding.AdapterTestItemBinding;

import java.util.List;

/**
 * @Author: xuwei
 * @Date: 2021/2/23 10:38
 * @Description: 测试adapter
 */
public class TestAdapter extends BaseAdapter<AdapterTestItemBinding, String> {
    public TestAdapter(Context context, List<String> listData) {
        super(context, listData);
    }

    @Override
    public void convert(AdapterTestItemBinding v, String string, int position) {
        v.tvTest.setText(string + position);
    }
}
