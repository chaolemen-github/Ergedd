package com.chaolemen.ergedd.hear.presenter;

import com.chaolemen.ergedd.hear.bean.TabHearBean;
import com.chaolemen.ergedd.hear.contract.TabHearContract;
import com.chaolemen.ergedd.hear.model.TabHearModel;
import com.chaolemen.mvplibrary.model.ModelFractory;
import com.chaolemen.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class TabHearPresenter extends BasePresenter<TabHearContract.View> implements TabHearContract.Presenter {


    @Override
    public void getDataTabHear(String channel) {
        TabHearModel tabHearModel = ModelFractory.createModel(TabHearModel.class);
        tabHearModel.getDataTabHear(channel, this, getLifecycle());
    }

    @Override
    public void onSuccessHear(List<TabHearBean> tabBeans) {
        mView.onSuccessHear(tabBeans);
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
