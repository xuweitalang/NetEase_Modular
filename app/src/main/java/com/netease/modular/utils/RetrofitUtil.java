package com.netease.modular.utils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author: xuwei
 * @Date: 2021/2/20 15:11
 * @Description: 线程调度
 */
public class RxJavaUtil {
    public static <T> Observable toSubscribe(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
