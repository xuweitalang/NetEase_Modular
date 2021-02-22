package com.netease.modular.main;

import com.netease.common.base.mvc.BaseModel;
import com.netease.common.http.BaseHttpResult;
import com.netease.modular.main.model.entity.User;
import com.netease.modular.utils.RetrofitUtil;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

/**
 * @Author: xuwei
 * @Date: 2021/2/20 15:42
 * @Description:
 */
public class MainModel extends BaseModel implements MainContract.Model {
    @Override
    public Observable<BaseHttpResult<List<Object>>> getData() {
        return RetrofitUtil.getHttpService().getData();
    }

    @Override
    public Observable<BaseHttpResult<User>> login(Map loginRequest) {
//        return RxSchedulers.createCommonObservable(RetrofitUtil.getHttpService().login(loginRequest));
        return RetrofitUtil.getHttpService().login(loginRequest);
    }
}
