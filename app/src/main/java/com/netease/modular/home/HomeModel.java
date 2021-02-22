package com.netease.modular.home;

import com.netease.common.base.mvc.BaseModel;
import com.netease.common.http.BaseHttpResult;
import com.netease.modular.main.entity.User;
import com.netease.modular.utils.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @Author: xuwei
 * @Date: 2021/2/22 16:04
 * @Description:
 */
public class HomeModel extends BaseModel implements HomeContract.Model {

    @Override
    public Observable<BaseHttpResult<User>> login(Map loginRequest) {
        return RetrofitUtil.getHttpService().login(loginRequest);
    }
}
