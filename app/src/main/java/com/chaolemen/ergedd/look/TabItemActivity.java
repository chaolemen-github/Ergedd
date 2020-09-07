package com.chaolemen.ergedd.look;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.app.Contents;
import com.chaolemen.ergedd.look.adapter.TabItemAdapter;
import com.chaolemen.ergedd.look.bean.TabItemBean;
import com.chaolemen.ergedd.look.contract.TabItemContract;
import com.chaolemen.ergedd.look.parmasen.TabParameter;
import com.chaolemen.ergedd.look.presenter.TabItemPresenter;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;
import com.chaolemen.mvplibrary.base.BaseMvpActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TabItemActivity extends BaseMvpActivity<TabItemContract.View, TabItemPresenter> implements TabItemContract.View {

    @BindView(R.id.recycler_look_tab_item)
    RecyclerView mRecyclerLookTabItem;
    private TabItemAdapter tabItemAdapter;
    private List<TabItemBean> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tab_item;
    }

    @Override
    protected TabItemPresenter initPresenter() {
        return new TabItemPresenter();
    }

    @Override
    protected void initData() {
        //获取用intent带过来的id
        int id = getIntent().getIntExtra(Contents.TAB_ITEM_ID, 0);
        //创建一个存放参数的实体对象
        TabParameter tabParameter = new TabParameter();
        tabParameter.setLimit(100);
        tabParameter.setOffset(0);
        tabParameter.setAddition_album_count(20);
        tabParameter.setChannel("new");
        //调用presenter的方法
        mPresenter.getDataTabItem(id, tabParameter);
    }

    @Override
    public void onSuccessTabItem(List<TabItemBean> tabItemBeans) {
        mRecyclerLookTabItem.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerLookTabItem.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));

        list = new ArrayList<>();
        list.addAll(tabItemBeans);
        tabItemAdapter = new TabItemAdapter(list, this, R.layout.activity_tab_look_item);
        mRecyclerLookTabItem.setAdapter(tabItemAdapter);

        tabItemAdapter.setItemClickListener(new BaseAdapter.ItemClickListener() {
            @Override
            public void onClickItem(int postion) {
                Toast.makeText(TabItemActivity.this, "点击列表", Toast.LENGTH_SHORT).show();
            }
        });

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
