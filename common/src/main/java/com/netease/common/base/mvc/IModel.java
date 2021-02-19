package com.netease.common.base.mvc;

import io.reactivex.disposables.Disposable;

/**
 * @Author: xuwei
 * @Date: 2021/2/18 15:33
 * @Description:
 */
interface IModel {
    void addDisposable(Disposable disposable);

    void onDetach();
}
