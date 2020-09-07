package com.chaolemen.ergedd.look.presenter;

import com.chaolemen.ergedd.look.bean.TabItemBean;
import com.chaolemen.ergedd.look.contract.TabItemContract;
import com.chaolemen.ergedd.look.model.TabItemModel;
import com.chaolemen.ergedd.look.parmasen.TabParameter;
import com.chaolemen.mvplibrary.model.ModelFractory;
import com.chaolemen.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class TabItemPresenter extends BasePresenter<TabItemContract.View> implements TabItemContract.Presenter {
    @Override
    public void getDataTabItem(int id, TabParameter tabParameter) {
        TabItemModel tabItemModel = ModelFractory.createModel(TabItemModel.class);
        tabItemModel.getDataTabItem(id,tabParameter,this,getLifecycle());
    }

    @Override
    public void onSuccessTabItem(List<TabItemBean> tabItemBeans) {
        mView.onSuccessTabItem(tabItemBeans);
    }

    @Override
    public void onFail(String error) {
        mView.onFail(error);
    }

    @Override
    public void onCancel() {
        mView.onCancel();
    }
}
