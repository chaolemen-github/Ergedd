package com.chaolemen.ergedd.hear.adapter;

import android.content.Context;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.hear.bean.TabHearBean;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;
import com.chaolemen.mvplibrary.adapter.BaseViewHolder;

import java.util.List;

public class TabHearAdapter extends BaseAdapter<TabHearBean.PlaylistsBean> {

    public TabHearAdapter(List<TabHearBean.PlaylistsBean> datas, Context context, int itemlayoutId) {
        super(datas, context, itemlayoutId);
    }

    @Override
    protected void bindData(BaseViewHolder holder, TabHearBean.PlaylistsBean playlistsBean) {
        holder.setImageViewContent(R.id.iv_tab_hear_img,playlistsBean.getImage());
        holder.setTextViewContent(R.id.tv_tab_hear_title,playlistsBean.getName());
        holder.setTextViewContent(R.id.tv_tab_hear_text,playlistsBean.getDescription());
        holder.setTextViewContent(R.id.tv_tab_hear_count,"共"+playlistsBean.getCount()+"首");
    }
}
