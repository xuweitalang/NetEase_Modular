package com.netease.common.base.mvp;

import androidx.viewbinding.ViewBinding;

import com.netease.common.base.BaseActivity;

/**
 * @Author: xuwei
 * @Date: 2021/2/18 17:06
 * @Description:
 */
public abstract class BaseMvpActivity<VB extends ViewBinding, V extends IView, P extends IPresenter<V>> extends BaseActivity<VB> implements IView {

    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected void initView() {
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
