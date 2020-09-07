package com.chaolemen.ergedd.hear.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.hear.adapter.TabHearAdapter;
import com.chaolemen.ergedd.hear.bean.TabHearBean;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabHearFragment extends Fragment {


    private RecyclerView mHearTabRecycler;
    private List<TabHearBean.PlaylistsBean> list;
    private TabHearAdapter tabHearAdapter;

    public TabHearFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_tab_hear, container, false);
        list = (List<TabHearBean.PlaylistsBean>) getArguments().getSerializable("list");
        initView(inflate);
        return inflate;
    }

    private void initView(final View itemView) {
        mHearTabRecycler = (RecyclerView) itemView.findViewById(R.id.recycler_hear_tab);

        mHearTabRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHearTabRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),RecyclerView.VERTICAL));

        tabHearAdapter = new TabHearAdapter(list, getActivity(), R.layout.fragment_tab_hear_item);
        mHearTabRecycler.setAdapter(tabHearAdapter);
    }

}
