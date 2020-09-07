package com.chaolemen.ergedd.hear.contract;

import com.chaolemen.ergedd.hear.bean.SiftHearItemBean;
import com.chaolemen.ergedd.hear.bean.SiftHearTwoBean;
import com.chaolemen.ergedd.look.bean.SiftItemBean;
import com.chaolemen.ergedd.look.bean.SiftTwoBean;
import com.chaolemen.ergedd.look.parmasen.SiftItemParameter;
import com.chaolemen.ergedd.look.parmasen.SiftTwoParameter;
import com.chaolemen.mvplibrary.model.BaseModel;
import com.chaolemen.mvplibrary.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

public interface SiftHearContract {
    interface Model extends BaseModel {
        void getDataSiftHearTwo(String channel, SiftHearCallBack siftHearCallBack, LifecycleProvider lifecycleProvider);
        void getDataSiftHearItem(String channel, SiftHearCallBack siftHearCallBack, LifecycleProvider lifecycleProvider);
    }

    interface View extends BaseView {
        void onSuccessSiftHearTwo(List<SiftHearTwoBean> siftTwoBeans);
        void onSuccessSiftHearItem(List<SiftHearItemBean> siftItemBeans);
    }

    interface Presenter extends SiftHearCallBack{
        void getDataSiftHearTwo(String channel);
        void getDataSiftHearItem(String channel);
    }

    interface SiftHearCallBack{
        void onSuccessSiftHearTwo(List<SiftHearTwoBean> siftHearTwoBeans);
        void onSuccessSiftHearItem(List<SiftHearItemBean> siftHearItemBeans);
        void onFail(String error);
        void onCancel();
    }
}
