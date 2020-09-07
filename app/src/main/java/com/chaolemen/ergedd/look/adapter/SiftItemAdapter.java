package com.chaolemen.ergedd.look.adapter;

import android.content.Context;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.look.bean.SiftItemBean;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;
import com.chaolemen.mvplibrary.adapter.BaseViewHolder;

import java.util.List;

public class SiftItemAdapter extends BaseAdapter<SiftItemBean> {

    public SiftItemAdapter(List<SiftItemBean> datas, Context context, int itemlayoutId) {
        super(datas, context, itemlayoutId);
    }

    @Override
    protected void bindData(BaseViewHolder holder, SiftItemBean siftItemBean) {
        holder.setImageViewContent(R.id.iv_sift_item_img,siftItemBean.getImage());
        holder.setTextViewContent(R.id.tv_sift_item_title,siftItemBean.getName());
    }
}
