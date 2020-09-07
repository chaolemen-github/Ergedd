package com.chaolemen.ergedd.hear.adapter;

import android.content.Context;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.hear.bean.SiftHearItemBean;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;
import com.chaolemen.mvplibrary.adapter.BaseViewHolder;

import java.util.List;

public class SiftHearItemAdapter extends BaseAdapter<SiftHearItemBean> {

    public SiftHearItemAdapter(List<SiftHearItemBean> datas, Context context, int itemlayoutId) {
        super(datas, context, itemlayoutId);
    }

    @Override
    protected void bindData(BaseViewHolder holder, SiftHearItemBean siftHearItemBean) {

        holder.setImageViewContent(R.id.iv_sift_hear_item_img2,siftHearItemBean.getPlaylists().get(0).getImage());
        holder.setImageViewContent(R.id.iv_sift_hear_item_img3,siftHearItemBean.getPlaylists().get(1).getImage());
        holder.setImageViewContent(R.id.iv_sift_hear_item_img4,siftHearItemBean.getPlaylists().get(2).getImage());
        holder.setTextViewContent(R.id.tv_sift_hear_item_title,siftHearItemBean.getName());
        holder.setTextViewContent(R.id.tv_sift_hear_item_text2,siftHearItemBean.getPlaylists().get(0).getName());
        holder.setTextViewContent(R.id.tv_sift_hear_item_text3,siftHearItemBean.getPlaylists().get(1).getName());
        holder.setTextViewContent(R.id.tv_sift_hear_item_text4,siftHearItemBean.getPlaylists().get(2).getName());
    }
}
