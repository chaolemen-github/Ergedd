package com.chaolemen.ergedd.look.adapter;

import android.content.Context;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.look.bean.TabBean;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;
import com.chaolemen.mvplibrary.adapter.BaseViewHolder;

import java.util.List;

public class TabAdapter extends BaseAdapter<TabBean.AlbumsBean> {

    public TabAdapter(List<TabBean.AlbumsBean> datas, Context context, int itemlayoutId) {
        super(datas, context, itemlayoutId);
    }

    @Override
    protected void bindData(BaseViewHolder holder, TabBean.AlbumsBean albumsBean) {

        holder.setImageViewContent(R.id.iv_tab_img,albumsBean.getImage_url());
        holder.setTextViewContent(R.id.tv_tab_title,albumsBean.getName());
        holder.setTextViewContent(R.id.tv_tab_text,albumsBean.getDescription());
        holder.setTextViewContent(R.id.tv_tab_count,"共"+albumsBean.getVideo_count()+"集");
    }
}
