package com.chaolemen.ergedd.look.contract;

import com.chaolemen.ergedd.look.bean.SItemBean;
import com.chaolemen.mvplibrary.model.BaseModel;
import com.chaolemen.mvplibrary.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

public interface SiftItemContract {
    interface Model extends BaseModel {
        void getDataSift(int id, SiftItemCallBack siftItemCallBack, LifecycleProvider lifecycleProvider);
    }

    interface View extends BaseView {
        void onSuccessSIftItem(SItemBean sItemBean);
    }

    interface Presenter extends SiftItemCallBack{
        void getDataSift(int id);
    }

    interface SiftItemCallBack{
        void onSuccessSiftItem(SItemBean sItemBean);
        void onFail(String error);
        void onCancel();
    }
}
