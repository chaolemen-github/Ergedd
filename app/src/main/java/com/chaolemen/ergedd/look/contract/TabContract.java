package com.chaolemen.ergedd.look.contract;

import com.chaolemen.ergedd.look.bean.TabBean;
import com.chaolemen.ergedd.look.parmasen.TabParameter;
import com.chaolemen.mvplibrary.model.BaseModel;
import com.chaolemen.mvplibrary.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

public interface TabContract {
    interface Model extends BaseModel {
        void getDataLook(TabParameter tabParameter, TabCallBack tabCallBack, LifecycleProvider lifecycleProvider);
    }

    interface View extends BaseView {
        void onSuccessLook(List<TabBean> tabBeans);
    }

    interface Presenter extends TabCallBack{
        void getDataLook(TabParameter tabParameter);
    }

    interface TabCallBack{
        void onSuccessLook(List<TabBean> tabBeans);
        void onFailLook(String error,int code);
        void onCancel();
    }
}
