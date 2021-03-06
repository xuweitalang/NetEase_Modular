package com.netease.modular.main;

import com.netease.common.base.mvp.IModel;
import com.netease.common.base.mvp.IPresenter;
import com.netease.common.base.mvp.IView;

/**
 * @Author: xuwei
 * @Date: 2021/2/19 16:36
 * @Description:
 */
public interface MainContract {
    interface View extends IView {
    }

    interface Model extends IModel {
    }

    interface Presenter extends IPresenter<View> {
    }
}
