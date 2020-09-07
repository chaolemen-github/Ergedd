package com.chaolemen.ergedd.look.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.app.Contents;
import com.chaolemen.ergedd.look.TabItemActivity;
import com.chaolemen.ergedd.look.adapter.TabAdapter;
import com.chaolemen.ergedd.look.bean.TabBean;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {


    private RecyclerView mTabRecycler;
    private List<TabBean.AlbumsBean> albums;
    private TabAdapter tabAdapter;

    public TabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_tab, container, false);
        albums = (List<TabBean.AlbumsBean>) getArguments().getSerializable("list");
        initView(inflate);
        return inflate;
    }

    private void initView(final View itemView) {
        mTabRecycler = (RecyclerView) itemView.findViewById(R.id.recycler_tab);

        mTabRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTabRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),RecyclerView.VERTICAL));

        tabAdapter = new TabAdapter(albums, getActivity(), R.layout.fragment_look_tab);
        mTabRecycler.setAdapter(tabAdapter);

        tabAdapter.setItemClickListener(new BaseAdapter.ItemClickListener() {
            @Override
            public void onClickItem(int postion) {
                int id = albums.get(postion).getId();
                LogUtils.e("动画"+id);
                Intent intent = new Intent(getActivity(), TabItemActivity.class);
                intent.putExtra(Contents.TAB_ITEM_ID,id);
                startActivity(intent);
            }
        });

    }

}
