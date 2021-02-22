package com.netease.common.base.mvc;

import androidx.viewbinding.ViewBinding;

import com.netease.common.base.BaseFragment;

/**
 * @Author: xuwei
 * @Date: 2021/2/22 15:38
 * @Description:
 */
public abstract class BaseMvpFragment<VB extends ViewBinding, V extends IView, P extends IPresenter<V>> extends BaseFragment<VB> implements IView {

    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected void initView() {
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
