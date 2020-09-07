package com.chaolemen.ergedd.hear.presenter;

import com.chaolemen.ergedd.hear.bean.SiftHearItemBean;
import com.chaolemen.ergedd.hear.bean.SiftHearTwoBean;
import com.chaolemen.ergedd.hear.contract.SiftHearContract;
import com.chaolemen.ergedd.hear.model.SiftHearModel;
import com.chaolemen.mvplibrary.model.ModelFractory;
import com.chaolemen.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class SiftHearPresenter extends BasePresenter<SiftHearContract.View> implements SiftHearContract.Presenter {
    @Override
    public void getDataSiftHearTwo(String channel) {

        SiftHearModel siftHearModel = ModelFractory.createModel(SiftHearModel.class);
        siftHearModel.getDataSiftHearTwo(channel, this, getLifecycle());
    }

    @Override
    public void getDataSiftHearItem(String channel) {
        SiftHearModel siftHearModel = ModelFractory.createModel(SiftHearModel.class);
        siftHearModel.getDataSiftHearItem(channel, this, getLifecycle());
    }

    @Override
    public void onSuccessSiftHearTwo(List<SiftHearTwoBean> siftHearTwoBeans) {
        mView.onSuccessSiftHearTwo(siftHearTwoBeans);
    }

    @Override
    public void onSuccessSiftHearItem(List<SiftHearItemBean> siftHearItemBeans) {
        mView.onSuccessSiftHearItem(siftHearItemBeans);
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
