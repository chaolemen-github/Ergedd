package com.chaolemen.ergedd.look.contract;

import com.chaolemen.ergedd.look.bean.SiftItemBean;
import com.chaolemen.ergedd.look.bean.SiftTwoBean;
import com.chaolemen.ergedd.look.parmasen.SiftItemParameter;
import com.chaolemen.ergedd.look.parmasen.SiftTwoParameter;
import com.chaolemen.mvplibrary.model.BaseModel;
import com.chaolemen.mvplibrary.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

public interface SiftContract {
    interface Model extends BaseModel {
        void getDataTwo(SiftTwoParameter siftTwoParameter, SiftCallBack siftCallBack, LifecycleProvider lifecycleProvider);
        void getDataItem(SiftItemParameter siftItemParameter, SiftCallBack siftCallBack, LifecycleProvider lifecycleProvider);
    }

    interface View extends BaseView {
        void onSuccessTwo(List<SiftTwoBean> siftTwoBeans);
        void onSuccessItem(List<SiftItemBean> siftItemBeans);
    }

    interface Presenter extends SiftCallBack{
        void getDataTwo(SiftTwoParameter siftTwoParameter);
        void getDataItem(SiftItemParameter siftItemParameter);
    }

    interface SiftCallBack{
        void onSuccessTwo(List<SiftTwoBean> siftTwoBeans);
        void onSuccessItem(List<SiftItemBean> siftItemBeans);
        void onFail(String error);
        void onCancel();
    }
}
