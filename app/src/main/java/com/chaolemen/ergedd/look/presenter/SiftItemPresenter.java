package com.chaolemen.ergedd.look.presenter;

import com.chaolemen.ergedd.look.bean.SItemBean;
import com.chaolemen.ergedd.look.contract.SiftItemContract;
import com.chaolemen.ergedd.look.model.SiftItemModel;
import com.chaolemen.ergedd.look.model.SiftModel;
import com.chaolemen.mvplibrary.model.ModelFractory;
import com.chaolemen.mvplibrary.presenter.BasePresenter;

public class SiftItemPresenter extends BasePresenter<SiftItemContract.View> implements SiftItemContract.Presenter {
    @Override
    public void getDataSift(int id) {
        SiftItemModel siftItemModel = ModelFractory.createModel(SiftItemModel.class);
        siftItemModel.getDataSift(id, this, getLifecycle());
    }

    @Override
    public void onSuccessSiftItem(SItemBean sItemBean) {
        mView.onSuccessSIftItem(sItemBean);
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
