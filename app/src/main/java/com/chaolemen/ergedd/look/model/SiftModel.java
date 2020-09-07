package com.chaolemen.ergedd.look.model;

import com.chaolemen.ergedd.look.bean.SiftItemBean;
import com.chaolemen.ergedd.look.bean.SiftTwoBean;
import com.chaolemen.ergedd.look.contract.SiftContract;
import com.chaolemen.ergedd.look.parmasen.SiftItemParameter;
import com.chaolemen.ergedd.look.parmasen.SiftTwoParameter;
import com.chaolemen.ergedd.net.ErgeddHttpCallBack;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class SiftModel implements SiftContract.Model {
    @Override
    public void getDataTwo(SiftTwoParameter siftTwoParameter, final SiftContract.SiftCallBack siftCallBack, LifecycleProvider lifecycleProvider) {
        HashMap<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("channel", siftTwoParameter.getChannel());
        parameterMap.put("offset", siftTwoParameter.getOffset());
        parameterMap.put("limit", siftTwoParameter.getLimit());
        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/albums/home_recommended")
                .setParamser(parameterMap)
                .setLifecycleProvider(lifecycleProvider)
                .build()
                .request(new ErgeddHttpCallBack<List<SiftTwoBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        siftCallBack.onFail(message + code);
                    }

                    @Override
                    public void cancle() {
                        siftCallBack.onCancel();
                    }

                    @Override
                    public void onSuccess(List<SiftTwoBean> siftTwoBeans) {
                        siftCallBack.onSuccessTwo(siftTwoBeans);
                    }

                    @Override
                    public List<SiftTwoBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, SiftTwoBean.class);
                    }
                });
    }

    @Override
    public void getDataItem(SiftItemParameter siftItemParameter, final SiftContract.SiftCallBack siftCallBack, LifecycleProvider lifecycleProvider) {
        HashMap<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("type", siftItemParameter.getType());
        parameterMap.put("channel", siftItemParameter.getChannel());
        parameterMap.put("offset", siftItemParameter.getOffset());
        parameterMap.put("limit", siftItemParameter.getLimit());
        parameterMap.put("sensitive", siftItemParameter.getSensitive());

        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/home_items")
                .setParamser(parameterMap)
                .setLifecycleProvider(lifecycleProvider)
                .build()
                .request(new ErgeddHttpCallBack<List<SiftItemBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        siftCallBack.onFail(message + code);
                    }

                    @Override
                    public void cancle() {
                        siftCallBack.onCancel();
                    }

                    @Override
                    public void onSuccess(List<SiftItemBean> siftItemBeans) {
                        siftCallBack.onSuccessItem(siftItemBeans);
                    }

                    @Override
                    public List<SiftItemBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, SiftItemBean.class);
                    }
                });
    }
}
