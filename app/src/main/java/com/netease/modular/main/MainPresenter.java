package com.netease.modular.main;

import com.netease.common.base.mvc.BasePresenter;

/**
 * @Author: xuwei
 * @Date: 2021/2/20 15:45
 * @Description:
 */
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> implements MainContract.Presenter {
    private static final String TAG = "MainPresenter";

    @Override
    public MainContract.Model createModel() {
        return new MainModel();
    }
}
