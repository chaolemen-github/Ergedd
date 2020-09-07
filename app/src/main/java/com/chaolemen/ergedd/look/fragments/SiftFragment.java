package com.chaolemen.ergedd.look.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.app.Contents;
import com.chaolemen.ergedd.look.SiftItemActivity;
import com.chaolemen.ergedd.look.TabItemActivity;
import com.chaolemen.ergedd.look.adapter.SiftItemAdapter;
import com.chaolemen.ergedd.look.adapter.SiftTwoAdapter;
import com.chaolemen.ergedd.look.bean.SiftItemBean;
import com.chaolemen.ergedd.look.bean.SiftTwoBean;
import com.chaolemen.ergedd.look.contract.SiftContract;
import com.chaolemen.ergedd.look.parmasen.SiftItemParameter;
import com.chaolemen.ergedd.look.parmasen.SiftTwoParameter;
import com.chaolemen.ergedd.look.presenter.SiftPresenter;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;
import com.chaolemen.mvplibrary.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiftFragment extends BaseMvpFragment<SiftContract.View, SiftPresenter> implements SiftContract.View {


    @BindView(R.id.iv_sift_img1)
    ImageView mIvSiftImg1;
    @BindView(R.id.iv_sift_img2)
    ImageView mIvSiftImg2;
    @BindView(R.id.iv_sift_img3)
    ImageView mIvSiftImg3;
    @BindView(R.id.recycler_sift_two)
    RecyclerView mRecyclerSiftTwo;
    @BindView(R.id.recycler_sift_item)
    RecyclerView mRecyclerSiftItem;
    Unbinder unbinder;
    private List<SiftTwoBean> twoList;
    private List<SiftItemBean> itemList;
    private SiftTwoAdapter twoAdapter;
    private SiftItemAdapter itemAdapter;

    public SiftFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sift;
    }

    @Override
    protected SiftPresenter initPresenter() {
        return new SiftPresenter();
    }

    @Override
    protected void initData() {
        super.initData();

        SiftTwoParameter twoParameter = new SiftTwoParameter();
        twoParameter.setChannel("new");
        twoParameter.setOffset(0);
        twoParameter.setLimit(8);

        //调用网格布局的网络请求方法
        mPresenter.getDataTwo(twoParameter);

        SiftItemParameter itemParameter = new SiftItemParameter();
        itemParameter.setChannel("new");
        itemParameter.setType(1);
        itemParameter.setOffset(0);
        itemParameter.setLimit(20);
        itemParameter.setSensitive(8);

        //调用列表布局的网络请求方法
        mPresenter.getDataItem(itemParameter);

        //设置网格布局
        mRecyclerSiftTwo.setLayoutManager(new GridLayoutManager(mActivity, 4));
        //设置线性布局
        mRecyclerSiftItem.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerSiftItem.addItemDecoration(new DividerItemDecoration(mActivity, RecyclerView.VERTICAL));

        //网格的数据集合
        twoList = new ArrayList<>();
        //列表的数据集合
        itemList = new ArrayList<>();

        //创建网格布局的适配器
        twoAdapter = new SiftTwoAdapter(twoList, mActivity, R.layout.fragment_sift_two);
        mRecyclerSiftTwo.setAdapter(twoAdapter);

        //点击网格条目，跳转详情信息列表页面
        twoAdapter.setItemClickListener(new BaseAdapter.ItemClickListener() {
            @Override
            public void onClickItem(int postion) {
                int id = twoList.get(postion).getId();
                LogUtils.e("精选" + id);
                Intent intent = new Intent(getActivity(), SiftItemActivity.class);
                intent.putExtra(Contents.TAB_ITEM_ID, id);
                startActivity(intent);
            }
        });

        //创建列表的适配器
        itemAdapter = new SiftItemAdapter(itemList, mActivity, R.layout.fragment_sift_item);
        mRecyclerSiftItem.setAdapter(itemAdapter);

        itemAdapter.setItemClickListener(new BaseAdapter.ItemClickListener() {
            @Override
            public void onClickItem(int postion) {
                int id = itemList.get(postion).getId();
                Intent intent = new Intent(getActivity(), TabItemActivity.class);
                intent.putExtra(Contents.TAB_ITEM_ID, id);
                startActivity(intent);
            }
        });

    }

    //网格布局的网络请求的成功回调
    @Override
    public void onSuccessTwo(List<SiftTwoBean> siftTwoBeans) {

        twoList.addAll(siftTwoBeans);
        twoAdapter.setNewData(twoList);
    }

    //列表
    @Override
    public void onSuccessItem(List<SiftItemBean> siftItemBeans) {

        itemList.addAll(siftItemBeans);
        itemAdapter.setNewData(itemList);
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
