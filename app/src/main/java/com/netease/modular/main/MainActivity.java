package com.netease.modular.main;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.netease.common.base.mvp.BaseMvpActivity;
import com.netease.common.constant.Cons;
import com.netease.modular.BuildConfig;
import com.netease.modular.R;
import com.netease.modular.databinding.ActivityMainBinding;
import com.netease.modular.home.HomeFragment;
import com.netease.modular.main.entity.TabEntity;

import java.util.ArrayList;

public class MainActivity extends BaseMvpActivity<ActivityMainBinding, MainContract.View, MainContract.Presenter> implements MainContract.View {

    private HomeFragment mHomeFragment;
    private HomeFragment mVideoFragment;
    private HomeFragment mMineFragment;

    // 顶部滑动的标签栏
    private String[] mTitles = {"首页", "系列", "我的"};
    // 未被选中的图标
    private int[] mIconUnSelectIds = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    // 被选中的图标
    private int[] mIconSelectIds = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int mCurrIndex;

    @Override
    protected void initData() {
        if (BuildConfig.isRelease) {
            Log.e(Cons.TAG, "当前为：集成化模式，除app可运行，其他子模块都是Android Library");
        } else {
            Log.e(Cons.TAG, "当前为：组件化模式，app/order/personal子模块都可独立运行");
        }
    }

    @Override
    protected MainContract.Presenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        initTab();
    }

    /**
     * 初始化底部菜单
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
        }
        //为Tab赋值数据
        viewBinding.tabLayout.setTabData(mTabEntities);
        viewBinding.tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                //切换Fragment
                switchFragment(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        viewBinding.tabLayout.showDot(2);

        viewBinding.tabLayout.showDot(0);

        viewBinding.tabLayout.showMsg(1, 100);
    }

    @Override
    protected void start() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mCurrIndex = savedInstanceState.getInt("currTabIndex");
        }
        viewBinding.tabLayout.setCurrentTab(mCurrIndex);
        switchFragment(mCurrIndex);
    }

    /**
     * 切换Fragment
     *
     * @param position 下标
     */
    private void switchFragment(int position) {
        // Fragment事务管理器
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
//        LogUtils.d("current position tab" + position);
        switch (position) {
            case 0: //首页
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.getInstance(mTitles[0]);
                    transaction.add(R.id.fl_container, mHomeFragment, "home");
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
            case 1: //视频
                if (mVideoFragment == null) {
                    mVideoFragment = HomeFragment.getInstance(mTitles[1]);
                    transaction.add(R.id.fl_container, mVideoFragment, "video");
                } else {
                    transaction.show(mVideoFragment);
                }
                break;

            case 2: //更多
                if (mMineFragment == null) {
                    mMineFragment = HomeFragment.getInstance(mTitles[2]);
                    transaction.add(R.id.fl_container, mMineFragment, "mine");
                } else {
                    transaction.show(mMineFragment);
                }
                break;
            default:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.getInstance(mTitles[0]);
                    transaction.add(R.id.fl_container, mHomeFragment, "home");
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
        }
        mCurrIndex = position;
        viewBinding.tabLayout.setCurrentTab(mCurrIndex);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏所有的Fragment
     *
     * @param transaction transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (null != mHomeFragment) {
            transaction.hide(mHomeFragment);
        }
        if (null != mVideoFragment) {
            transaction.hide(mVideoFragment);
        }
        if (null != mMineFragment) {
            transaction.hide(mMineFragment);
        }

    }
}
