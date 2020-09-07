package com.chaolemen.ergedd.look.presenter;

import com.chaolemen.ergedd.look.bean.SiftItemBean;
import com.chaolemen.ergedd.look.bean.SiftTwoBean;
import com.chaolemen.ergedd.look.contract.SiftContract;
import com.chaolemen.ergedd.look.model.SiftModel;
import com.chaolemen.ergedd.look.parmasen.SiftItemParameter;
import com.chaolemen.ergedd.look.parmasen.SiftTwoParameter;
import com.chaolemen.mvplibrary.model.ModelFractory;
import com.chaolemen.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class SiftPresenter extends BasePresenter<SiftContract.View> implements SiftContract.Presenter {
    @Override
    public void getDataTwo(SiftTwoParameter siftTwoParameter) {
        SiftModel siftModel = ModelFractory.createModel(SiftModel.class);
        siftModel.getDataTwo(siftTwoParameter, this, getLifecycle());
    }

    @Override
    public void getDataItem(SiftItemParameter siftItemParameter) {
        SiftModel siftModel = ModelFractory.createModel(SiftModel.class);
        siftModel.getDataItem(siftItemParameter, this, getLifecycle());
    }

    @Override
    public void onSuccessTwo(List<SiftTwoBean> siftTwoBeans) {
        mView.onSuccessTwo(siftTwoBeans);
    }

    @Override
    public void onSuccessItem(List<SiftItemBean> siftItemBeans) {
        mView.onSuccessItem(siftItemBeans);
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
