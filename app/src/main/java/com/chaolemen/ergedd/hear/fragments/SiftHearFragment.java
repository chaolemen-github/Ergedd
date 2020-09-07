package com.chaolemen.ergedd.hear.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.hear.adapter.SiftHearItemAdapter;
import com.chaolemen.ergedd.hear.adapter.SiftHearTwoAdapter;
import com.chaolemen.ergedd.hear.bean.ItemBean;
import com.chaolemen.ergedd.hear.bean.SiftHearItemBean;
import com.chaolemen.ergedd.hear.bean.SiftHearTwoBean;
import com.chaolemen.ergedd.hear.contract.SiftHearContract;
import com.chaolemen.ergedd.hear.presenter.SiftHearPresenter;
import com.chaolemen.ergedd.look.adapter.SiftItemAdapter;
import com.chaolemen.ergedd.look.adapter.SiftTwoAdapter;
import com.chaolemen.ergedd.look.bean.SiftItemBean;
import com.chaolemen.ergedd.look.bean.SiftTwoBean;
import com.chaolemen.ergedd.net.ErgeddHttpCallBack;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.chaolemen.mvplibrary.base.BaseMvpFragment;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiftHearFragment extends BaseMvpFragment<SiftHearContract.View, SiftHearPresenter> implements SiftHearContract.View {

    @BindView(R.id.iv_sift_hear_img1)
    ImageView mIvSiftHearImg1;
    @BindView(R.id.iv_sift_hear_img2)
    ImageView mIvSiftHearImg2;
    @BindView(R.id.iv_sift_hear_img3)
    ImageView mIvSiftHearImg3;
    @BindView(R.id.recycler_sift_hear_two)
    RecyclerView mRecyclerSiftHearTwo;
    @BindView(R.id.recycler_sift_hear_item)
    RecyclerView mRecyclerSiftHearItem;
    private List<SiftHearTwoBean> twoHearList;
    private List<SiftHearItemBean> itemHearList;
    private SiftHearTwoAdapter siftHearTwoAdapter;
    private SiftHearItemAdapter siftHearItemAdapter;

    private String img="";

    public SiftHearFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sift_hear;
    }

    @Override
    protected SiftHearPresenter initPresenter() {
        return new SiftHearPresenter();
    }

    @Override
    protected void initData() {
        super.initData();


//        Glide.with(getActivity()).load(s).into(mIvSiftHearImg1);

//        String s1 = initImageView1("api/v1/audio_playlists/261");
//        Glide.with(getActivity()).load(s1).into(mIvSiftHearImg2);
//
//        String s2 = initImageView1("api/v1/audio_playlists/194");
//        Glide.with(getActivity()).load(s2).into(mIvSiftHearImg3);


        mPresenter.getDataSiftHearTwo("original");
        mPresenter.getDataSiftHearItem("original");
        //设置网格布局
        mRecyclerSiftHearTwo.setLayoutManager(new GridLayoutManager(mActivity, 3));
        //设置线性布局
        mRecyclerSiftHearItem.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerSiftHearItem.addItemDecoration(new DividerItemDecoration(mActivity, RecyclerView.VERTICAL));

        //网格的数据集合
        twoHearList = new ArrayList<>();
        //列表的数据集合
        itemHearList = new ArrayList<>();

        //创建网格布局的适配器
        siftHearTwoAdapter = new SiftHearTwoAdapter(twoHearList, mActivity, R.layout.fragment_sift_hear_two);
        mRecyclerSiftHearTwo.setAdapter(siftHearTwoAdapter);

        //创建列表的适配器
        siftHearItemAdapter = new SiftHearItemAdapter(itemHearList, mActivity, R.layout.fragment_sift_hear_item);
        mRecyclerSiftHearItem.setAdapter(siftHearItemAdapter);
        initImageView1();
        initImageView2();
        initImageView3();
    }

    private void initImageView1() {
        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/audio_playlists/258")
                .build()
                .request(new ErgeddHttpCallBack<ItemBean>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(ItemBean itemBean) {
                        String image = itemBean.getImage();
//                        urlStr.add(image);
                        Glide.with(getActivity()).load(image).into(mIvSiftHearImg1);
                        LogUtils.e("45645644"+image);

                    }

                    @Override
                    public ItemBean convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, ItemBean.class);
                    }
                });
    }

    private void initImageView2() {
        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/audio_playlists/261")
                .build()
                .request(new ErgeddHttpCallBack<ItemBean>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(ItemBean itemBean) {
                        String image = itemBean.getImage();
//                        urlStr.add(image);
                        Glide.with(getActivity()).load(image).into(mIvSiftHearImg2);
                        LogUtils.e("45645644"+image);

                    }

                    @Override
                    public ItemBean convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, ItemBean.class);
                    }
                });
    }

    private void initImageView3() {
        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/audio_playlists/194")
                .build()
                .request(new ErgeddHttpCallBack<ItemBean>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(ItemBean itemBean) {
                        String image = itemBean.getImage();
//                        urlStr.add(image);
                        Glide.with(getActivity()).load(image).into(mIvSiftHearImg3);
                        LogUtils.e("45645644"+image);

                    }

                    @Override
                    public ItemBean convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, ItemBean.class);
                    }
                });
    }

    @Override
    public void onSuccessSiftHearTwo(List<SiftHearTwoBean> siftTwoBeans) {

        twoHearList.addAll(siftTwoBeans);
        siftHearTwoAdapter.setNewData(twoHearList);
    }

    @Override
    public void onSuccessSiftHearItem(List<SiftHearItemBean> siftItemBeans) {

        itemHearList.addAll(siftItemBeans);
        siftHearItemAdapter.setNewData(itemHearList);
    }

    @Override
    public void onFail(String error) {
        mPresenter.onFail(error);
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
