package com.netease.common.base.mvp;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author: xuwei
 * @Date: 2021/2/18 14:02
 * @Description:
 */
public abstract class BasePresenter<V extends IBaseView> {
    private V mView;
    private CompositeDisposable mCompositeDisposable;

    public void attachView(V view) {
        this.mView = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    public void detachView() {
        if (mView != null) {
            mView = null;
        }
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    public V getView() {
        return mView;
    }

    protected void bindToLifecycle(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    public <T> ObservableTransformer<T, T> applySchedulers() {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
