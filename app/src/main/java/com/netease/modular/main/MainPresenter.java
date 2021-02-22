package com.netease.modular.main;

import android.util.Log;

import com.netease.common.base.mvc.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

    public void getData() {
//        addDispose(mModel.getData().subscribe(new Ob));
        mModel.getData();
    }

    public void login() {
        Map<String, String> request = new HashMap();
        request.put("loginName", "huangdp");
        request.put("password", "123456");
        addDispose(mModel.login(request).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userBaseHttpResult -> {
                    if (userBaseHttpResult.isSuccess()) {
                        Log.d(TAG, "login: " + userBaseHttpResult.getResultData().toString());
                        mView.loginSuccess(userBaseHttpResult.getResultData());
                    }
                }));
    }
}
