package com.netease.common.base.mvp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @Author: xuwei
 * @Date: 2021/2/18 14:39
 * @Description:
 */
public abstract class MvpBaseFragment<V extends IBaseView, P extends BasePresenter<V>> extends Fragment {
    protected P mPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = initPresenter();
        try {
            mPresenter.attachView((V) this);
        } catch (Exception e) {
            Log.e("MvpBaseFragment", "presenter attach view error, please check view type", e);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract P initPresenter();
}
