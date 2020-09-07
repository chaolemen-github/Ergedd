package com.chaolemen.ergedd.look.presenter;

import com.chaolemen.ergedd.look.bean.MateBean;
import com.chaolemen.ergedd.look.contract.MateContract;
import com.chaolemen.ergedd.look.model.MateModel;
import com.chaolemen.mvplibrary.model.ModelFractory;
import com.chaolemen.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class MatePresenter extends BasePresenter<MateContract.View> implements MateContract.Presenter {
    @Override
    public void getDataMate(String types) {
        MateModel mateModel = ModelFractory.createModel(MateModel.class);
        mateModel.getDataMate(types, this, getLifecycle());
    }

    @Override
    public void onSuccessMate(List<MateBean> mateBeans) {
        mView.onSuccessMate(mateBeans);
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
