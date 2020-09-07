package com.chaolemen.ergedd.hear.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.hear.bean.SiftHearTwoBean;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;
import com.chaolemen.mvplibrary.adapter.BaseViewHolder;

import java.util.List;

public class SiftHearTwoAdapter extends BaseAdapter<SiftHearTwoBean> {

    public SiftHearTwoAdapter(List<SiftHearTwoBean> datas, Context context, int itemlayoutId) {
        super(datas, context, itemlayoutId);
    }

    @Override
    protected void bindData(BaseViewHolder holder, SiftHearTwoBean siftHearTwoBean) {

        holder.setImageViewContent(R.id.iv_sift_hear_two_img, siftHearTwoBean.getImage());
        holder.setTextViewContent(R.id.tv_sift_hear_two_name, siftHearTwoBean.getName());
    }
}
