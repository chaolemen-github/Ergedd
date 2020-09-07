package com.chaolemen.ergedd.look.contract;

import com.chaolemen.ergedd.look.bean.TabItemBean;
import com.chaolemen.ergedd.look.parmasen.TabParameter;
import com.chaolemen.mvplibrary.model.BaseModel;
import com.chaolemen.mvplibrary.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

public interface TabItemContract {
    interface Model extends BaseModel {
        void getDataTabItem(int id, TabParameter tabParameter, TabItemCallBack tabItemCallBack, LifecycleProvider lifecycleProvider);
    }

    interface View extends BaseView {
        void onSuccessTabItem(List<TabItemBean> tabItemBeans);
    }


    interface Presenter extends TabItemCallBack{
        void getDataTabItem(int id, TabParameter tabParameter);
    }

    interface TabItemCallBack{
        void onSuccessTabItem(List<TabItemBean> tabItemBeans);
        void onFail(String error);
        void onCancel();
    }
}
