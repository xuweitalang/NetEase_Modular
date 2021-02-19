package com.netease.common.base.mvc;

/**
 * @Author: xuwei
 * @Date: 2021/2/18 15:34
 * @Description:
 */
interface IPresenter<V extends IView> {
    void attachView(V view);

    void detachView();
}
