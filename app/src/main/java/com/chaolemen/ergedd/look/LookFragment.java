package com.chaolemen.ergedd.look;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.app.BaseApp;
import com.chaolemen.ergedd.look.adapter.TabVPAdapter;
import com.chaolemen.ergedd.look.bean.TabBean;
import com.chaolemen.ergedd.look.contract.TabContract;
import com.chaolemen.ergedd.look.fragments.MateFragment;
import com.chaolemen.ergedd.look.fragments.SiftFragment;
import com.chaolemen.ergedd.look.fragments.TabFragment;
import com.chaolemen.ergedd.look.parmasen.TabParameter;
import com.chaolemen.ergedd.look.presenter.TabPresenter;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.chaolemen.mvplibrary.base.BaseMvpFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LookFragment extends BaseMvpFragment<TabContract.View, TabPresenter> implements TabContract.View {


    @BindView(R.id.tabLayout_look)
    TabLayout mTabLayoutLook;
    @BindView(R.id.vp_look)
    ViewPager mVpLook;
    Unbinder unbinder;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;

    public LookFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_look;
    }

    @Override
    protected TabPresenter initPresenter() {
        return new TabPresenter();
    }


    @Override
    protected void initData() {
        super.initData();

        TabParameter tabParameter = new TabParameter();
        tabParameter.setLimit(100);
        tabParameter.setOffset(0);
        tabParameter.setAddition_album_count(20);
        tabParameter.setChannel("new");

        mPresenter.getDataLook(tabParameter);
    }

    @Override
    public void onSuccessLook(List<TabBean> tabBeans) {
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        fragments.add(new SiftFragment());
        titles.add("精选");
        for (int i = 0; i < tabBeans.size(); i++) {
            TabBean tabBean = tabBeans.get(i);
            //用bundle传值
            List<TabBean.AlbumsBean> albums = tabBean.getAlbums();
            TabFragment tabFragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("list", (Serializable) albums);
            tabFragment.setArguments(bundle);
            //将fragment添加到集合中
            fragments.add(tabFragment);
            titles.add(tabBeans.get(i).getName());
        }

        fragments.add(new MateFragment());
        titles.add("伙伴");

        //用匿名内部类创建viewPager的适配器
        mVpLook.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });

        //绑定viewPager和tabLayout
        mTabLayoutLook.setupWithViewPager(mVpLook);

        //将tabLayout改成自私印
        mTabLayoutLook.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onFail(String error) {
        LogUtils.e(error);
    }

    @Override
    public void onCancel() {
        mPresenter.onCancel();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
