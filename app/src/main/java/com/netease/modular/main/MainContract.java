package com.netease.modular.main;

import com.netease.common.base.mvc.IModel;
import com.netease.common.base.mvc.IPresenter;
import com.netease.common.base.mvc.IView;
import com.netease.common.http.BaseHttpResult;
import com.netease.modular.main.model.entity.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

/**
 * @Author: xuwei
 * @Date: 2021/2/19 16:36
 * @Description:
 */
public interface MainContract {
    interface View extends IView {
        void loginSuccess(User user);
    }

    interface Model extends IModel {
        Observable<BaseHttpResult<List<Object>>> getData();

        Observable<BaseHttpResult<User>> login(Map loginRequest);

    }

    interface Presenter extends IPresenter<View> {
        void login();
    }
}
