package com.netease.modular.api;

/**
 * @Author: xuwei
 * @Date: 2021/2/22 13:57
 * @Description:
 */
public class CommonApi {
    private CommonApi() {
    }

    private static CommonApi mInstance;

    public static CommonApi getInstance() {
        if (mInstance == null) {
            synchronized (CommonApi.class) {
                if (mInstance == null) {
                    mInstance = new CommonApi();
                }
            }
        }
        return mInstance;
    }

//    public Observable<User> login() {
//        Map<String, String> request = new HashMap<>();
//        request.put("loginName", "huangdp");
//        request.put("password", "123456");
//        return RxSchedulers.createCommonObservable(RetrofitUtil.getHttpService().login(request));
//    }
}
