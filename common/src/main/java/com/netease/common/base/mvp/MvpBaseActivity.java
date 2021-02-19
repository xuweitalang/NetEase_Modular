package com.netease.common.base.mvp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Author: xuwei
 * @Date: 2021/2/18 13:51
 * @Description:
 */
public abstract class MvpBaseActivity<V extends IBaseView, P extends BasePresenter<V>> extends AppCompatActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        try {
            mPresenter.attachView((V) this);
        } catch (Exception e) {
            Log.e("MvpBaseActivity", "presenter attach view error, please check view type", e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract P initPresenter();
}
