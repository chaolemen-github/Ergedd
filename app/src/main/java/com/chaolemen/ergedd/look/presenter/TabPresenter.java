package com.chaolemen.ergedd.look.presenter;

import com.chaolemen.ergedd.look.bean.TabBean;
import com.chaolemen.ergedd.look.contract.TabContract;
import com.chaolemen.ergedd.look.model.TabModel;
import com.chaolemen.ergedd.look.parmasen.TabParameter;
import com.chaolemen.mvplibrary.model.ModelFractory;
import com.chaolemen.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class TabPresenter extends BasePresenter<TabContract.View> implements TabContract.Presenter {
    @Override
    public void getDataLook(TabParameter tabParameter) {
        //创建model的对象
        TabModel tabModel = ModelFractory.createModel(TabModel.class);
        //调用model的方法
        tabModel.getDataLook(tabParameter, this, getLifecycle());
    }

    @Override
    public void onSuccessLook(List<TabBean> tabBeans) {
        mView.onSuccessLook(tabBeans);
    }

    @Override
    public void onFailLook(String error, int code) {
        mView.onFail(error + code);
    }

    @Override
    public void onCancel() {
        mView.onCancel();
    }
}
