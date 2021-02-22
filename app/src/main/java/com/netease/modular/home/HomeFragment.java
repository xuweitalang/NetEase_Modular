package com.netease.modular.home;

import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.netease.common.base.mvc.BaseMvpFragment;
import com.netease.common.constant.RoutePath;
import com.netease.modular.databinding.FragmentHomeBinding;
import com.netease.modular.main.entity.User;

/**
 * @Author: xuwei
 */
public class HomeFragment extends BaseMvpFragment<FragmentHomeBinding, HomeContract.View, HomeContract.Presenter> implements HomeContract.View {

    private String mTitle;

    public static HomeFragment getInstance(String title) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        fragment.mTitle = title;
        return fragment;
    }

    @Override
    protected HomeContract.Presenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        viewBinding.btnOrder.setOnClickListener(v -> ARouter.getInstance().build(RoutePath.ROUTE_ORDER_MAIN).navigation());
        viewBinding.btnDemo.setOnClickListener(v -> ARouter.getInstance().build(RoutePath.ROUTE_DEMO_MAIN).navigation());
        viewBinding.btnLogin.setOnClickListener(v -> login());
    }

    private void login() {
        mPresenter.login();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void start() {

    }

    @Override
    public void loginSuccess(User user) {
        Toast.makeText(getActivity(), user.getUserId(), Toast.LENGTH_SHORT).show();
    }
}