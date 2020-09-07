package com.chaolemen.ergedd.hear.contract;

import com.chaolemen.ergedd.hear.bean.TabHearBean;
import com.chaolemen.mvplibrary.model.BaseModel;
import com.chaolemen.mvplibrary.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

public interface TabHearContract {
    interface Model extends BaseModel {
        void getDataTabHear(String channel, TabCallBack tabCallBack, LifecycleProvider lifecycleProvider);
    }

    interface View extends BaseView {
        void onSuccessHear(List<TabHearBean> tabBeans);
    }

    interface Presenter extends TabCallBack{
        void getDataTabHear(String channel);
    }

    interface TabCallBack{
        void onSuccessHear(List<TabHearBean> tabBeans);
        void onFail(String error);
        void onCancel();
    }
}
