package com.chaolemen.ergedd.look.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.app.Contents;
import com.chaolemen.ergedd.look.TabItemActivity;
import com.chaolemen.ergedd.look.adapter.MateAdapter;
import com.chaolemen.ergedd.look.bean.MateBean;
import com.chaolemen.ergedd.look.contract.MateContract;
import com.chaolemen.ergedd.look.presenter.MatePresenter;
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
public class MateFragment extends BaseMvpFragment<MateContract.View, MatePresenter> implements MateContract.View {


    @BindView(R.id.recycler_mate)
    RecyclerView mRecyclerMate;
    Unbinder unbinder;
    private List<MateBean> list;
    private MateAdapter mateAdapter;

    public MateFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mate;
    }

    @Override
    protected MatePresenter initPresenter() {
        return new MatePresenter();
    }

    @Override
    protected void initData() {
        super.initData();

        mPresenter.getDataMate("brand_area");

        mRecyclerMate.setLayoutManager(new GridLayoutManager(mActivity, 3));
        list = new ArrayList<>();

        mateAdapter = new MateAdapter(list, mActivity, R.layout.fragment_mate_item);
        mRecyclerMate.setAdapter(mateAdapter);

        mateAdapter.setItemClickListener(new BaseAdapter.ItemClickListener() {
            @Override
            public void onClickItem(int postion) {
                int id = list.get(postion).getId();
                LogUtils.e("伙伴"+id);
                Intent intent = new Intent(getActivity(), TabItemActivity.class);
                intent.putExtra(Contents.TAB_ITEM_ID,id);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onSuccessMate(List<MateBean> mateBeans) {
        list.addAll(mateBeans);
        mateAdapter.setNewData(list);
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
