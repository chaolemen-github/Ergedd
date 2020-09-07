package com.chaolemen.ergedd.look.adapter;

import android.content.Context;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.look.bean.SiftTwoBean;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;
import com.chaolemen.mvplibrary.adapter.BaseViewHolder;

import java.util.List;

public class SiftTwoAdapter extends BaseAdapter<SiftTwoBean> {

    public SiftTwoAdapter(List<SiftTwoBean> datas, Context context, int itemlayoutId) {
        super(datas, context, itemlayoutId);
    }

    @Override
    protected void bindData(BaseViewHolder holder, SiftTwoBean siftTwoBean) {
        holder.setImageViewContent(R.id.iv_sift_two_img,siftTwoBean.getIcon_url());
        holder.setTextViewContent(R.id.tv_sift_two_name,siftTwoBean.getName());
    }
}
