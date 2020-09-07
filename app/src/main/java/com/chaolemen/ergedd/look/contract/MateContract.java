package com.chaolemen.ergedd.look.contract;

import com.chaolemen.ergedd.look.bean.MateBean;
import com.chaolemen.mvplibrary.model.BaseModel;
import com.chaolemen.mvplibrary.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

public interface MateContract {
    interface Model extends BaseModel {
        void getDataMate(String types, MateCallBack mateCallBack, LifecycleProvider lifecycleProvider);
    }

    interface View extends BaseView {
        void onSuccessMate(List<MateBean> mateBeans);
    }

    interface Presenter extends MateCallBack{
        void getDataMate(String types);
    }

    interface MateCallBack{
        void onSuccessMate(List<MateBean> mateBeans);
        void onFail(String error);
        void onCancel();
    }
}
