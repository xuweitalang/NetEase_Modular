package com.netease.modular.utils;

import com.netease.common.http.BaseRetrofit;
import com.netease.modular.api.ApiService;

/**
 * @Author: xuwei
 * @Date: 2021/2/20 15:11
 * @Description:
 */
public class RetrofitUtil extends BaseRetrofit {
    private static ApiService httpService;

    public static ApiService getHttpService() {
        if (httpService == null) {
            httpService = getRetrofit().create(ApiService.class);
        }
        return httpService;
    }

}
