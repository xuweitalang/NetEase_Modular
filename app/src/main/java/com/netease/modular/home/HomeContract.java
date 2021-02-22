package com.netease.modular.home;

import com.netease.common.base.mvc.IModel;
import com.netease.common.base.mvc.IPresenter;
import com.netease.common.base.mvc.IView;
import com.netease.common.http.BaseHttpResult;
import com.netease.modular.main.entity.User;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @Author: xuwei
 * @Date: 2021/2/22 15:50
 * @Description:
 */
public interface HomeContract {
    interface View extends IView {
        void loginSuccess(User user);
    }

    interface Model extends IModel {
        Observable<BaseHttpResult<User>> login(Map loginRequest);
    }

    interface Presenter extends IPresenter<View> {
        void login();
    }
}
