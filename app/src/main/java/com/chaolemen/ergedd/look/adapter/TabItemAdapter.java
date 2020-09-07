package com.chaolemen.ergedd.look.adapter;

import android.content.Context;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.look.bean.SiftItemBean;
import com.chaolemen.ergedd.look.bean.TabItemBean;
import com.chaolemen.mvplibrary.adapter.BaseAdapter;
import com.chaolemen.mvplibrary.adapter.BaseViewHolder;

import java.util.List;

public class TabItemAdapter extends BaseAdapter<TabItemBean> {

    public TabItemAdapter(List<TabItemBean> datas, Context context, int itemlayoutId) {
        super(datas, context, itemlayoutId);
    }

    @Override
    protected void bindData(BaseViewHolder holder, TabItemBean siftItemBean) {
        holder.setImageViewContent(R.id.iv_tab_item_img,siftItemBean.getImage());
        holder.setTextViewContent(R.id.tv_tab_item_title,siftItemBean.getName());
    }
}
