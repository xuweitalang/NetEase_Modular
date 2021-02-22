package com.netease.modular.api;

import com.netease.common.http.BaseHttpResult;
import com.netease.modular.main.model.entity.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @Author: xuwei
 * @Date: 2021/2/20 15:09
 * @Description:
 */
public interface ApiService {
    @GET("api/data/Android/10/1")
    Observable<BaseHttpResult<List<Object>>> getData();

    /**
     * 登录
     *
     * @return
     */
    @POST("app/login")
    Observable<BaseHttpResult<User>> login(@Body Map loginRequest);

}
