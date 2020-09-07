package com.chaolemen.ergedd.look.adapter;

import android.content.Context;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.look.bean.MateBean;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;
import com.chaolemen.mvplibrary.adapter.BaseViewHolder;

import java.util.List;

public class MateAdapter extends BaseAdapter<MateBean> {

    public MateAdapter(List<MateBean> datas, Context context, int itemlayoutId) {
        super(datas, context, itemlayoutId);
    }

    @Override
    protected void bindData(BaseViewHolder holder, MateBean mateBean) {

        holder.setImageViewContent(R.id.iv_mate_img,mateBean.getImage_url());
        holder.setTextViewContent(R.id.tv_mate_title,mateBean.getTitle());
    }
}
