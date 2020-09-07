package com.chaolemen.ergedd.look.model;

import com.chaolemen.ergedd.look.bean.MateBean;
import com.chaolemen.ergedd.look.contract.MateContract;
import com.chaolemen.ergedd.net.ErgeddHttpCallBack;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class MateModel implements MateContract.Model {
    @Override
    public void getDataMate(String types, final MateContract.MateCallBack mateCallBack, LifecycleProvider lifecycleProvider) {

        HashMap<String, Object> headerMap = new HashMap<>();
        headerMap.put("Authorization", "ergedd_android:Android");

        HashMap<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("types", types);

        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/app_configs")
                .setParamser(parameterMap)
                .setHeadres(headerMap)
                .setLifecycleProvider(lifecycleProvider)
                .build()
                .request(new ErgeddHttpCallBack<List<MateBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        mateCallBack.onFail(message + code);
                    }

                    @Override
                    public void cancle() {
                        mateCallBack.onCancel();
                    }

                    @Override
                    public void onSuccess(List<MateBean> mateBeans) {
                        mateCallBack.onSuccessMate(mateBeans);
                    }

                    @Override
                    public List<MateBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, MateBean.class);
                    }
                });
    }
}
