package com.chaolemen.ergedd.hear;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.hear.bean.TabHearBean;
import com.chaolemen.ergedd.hear.contract.TabHearContract;
import com.chaolemen.ergedd.hear.fragments.SiftHearFragment;
import com.chaolemen.ergedd.hear.fragments.TabHearFragment;
import com.chaolemen.ergedd.hear.presenter.TabHearPresenter;
import com.chaolemen.ergedd.look.fragments.MateFragment;
import com.chaolemen.ergedd.look.fragments.SiftFragment;
import com.chaolemen.ergedd.look.fragments.TabFragment;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.chaolemen.mvplibrary.base.BaseMvpFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HearFragment extends BaseMvpFragment<TabHearContract.View, TabHearPresenter> implements TabHearContract.View {


    @BindView(R.id.tabLayout_hear)
    TabLayout mTabLayoutHear;
    @BindView(R.id.vp_hear)
    ViewPager mVpHear;
    Unbinder unbinder;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;


    public HearFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hear;
    }


    @Override
    protected TabHearPresenter initPresenter() {
        return new TabHearPresenter();
    }

    @Override
    protected void initData() {
        super.initData();

        mPresenter.getDataTabHear("original");
    }

    @Override
    public void onSuccessHear(List<TabHearBean> tabBeans) {
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        fragments.add(new SiftHearFragment());
        titles.add("精选");
        for (int i = 0; i < tabBeans.size(); i++) {
            TabHearBean tabBean = tabBeans.get(i);
            //用bundle传值
            List<TabHearBean.PlaylistsBean> playlists = tabBean.getPlaylists();
            TabHearFragment tabHearFragment = new TabHearFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("list", (Serializable) playlists);
            tabHearFragment.setArguments(bundle);
            //将fragment添加到集合中
            fragments.add(tabHearFragment);
            titles.add(tabBeans.get(i).getName());
        }

        //用匿名内部类创建viewPager的适配器
        mVpHear.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
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
        mTabLayoutHear.setupWithViewPager(mVpHear);

        //将tabLayout改成自私印
        mTabLayoutHear.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onFail(String error) {
        LogUtils.e(error);
    }

    @Override
    public void onCancel() {
        mPresenter.onCancel();
    }
}
