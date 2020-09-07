package com.chaolemen.ergedd.hear.model;

import com.chaolemen.ergedd.hear.bean.SiftHearItemBean;
import com.chaolemen.ergedd.hear.bean.SiftHearTwoBean;
import com.chaolemen.ergedd.hear.contract.SiftHearContract;
import com.chaolemen.ergedd.net.ErgeddHttpCallBack;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class SiftHearModel implements SiftHearContract.Model {
    @Override
    public void getDataSiftHearTwo(String channel, final SiftHearContract.SiftHearCallBack siftHearCallBack, LifecycleProvider lifecycleProvider) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("channel", channel);
        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/audio_playlists/excellent")
                .setParamser(hashMap)
                .setLifecycleProvider(lifecycleProvider)
                .build()
                .request(new ErgeddHttpCallBack<List<SiftHearTwoBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        siftHearCallBack.onFail(message + code);
                    }

                    @Override
                    public void cancle() {
                        siftHearCallBack.onCancel();
                    }

                    @Override
                    public void onSuccess(List<SiftHearTwoBean> siftHearTwoBeans) {
                        siftHearCallBack.onSuccessSiftHearTwo(siftHearTwoBeans);
                    }

                    @Override
                    public List<SiftHearTwoBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, SiftHearTwoBean.class);
                    }
                });
    }

    @Override
    public void getDataSiftHearItem(String channel, final SiftHearContract.SiftHearCallBack siftHearCallBack, LifecycleProvider lifecycleProvider) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("channel", channel);
        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/audio_categories")
                .setParamser(hashMap)
                .setLifecycleProvider(lifecycleProvider)
                .build()
                .request(new ErgeddHttpCallBack<List<SiftHearItemBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        siftHearCallBack.onFail(message + code);
                    }

                    @Override
                    public void cancle() {
                        siftHearCallBack.onCancel();
                    }

                    @Override
                    public void onSuccess(List<SiftHearItemBean> siftHearItemBeans) {
                        siftHearCallBack.onSuccessSiftHearItem(siftHearItemBeans);
                    }

                    @Override
                    public List<SiftHearItemBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, SiftHearItemBean.class);
                    }
                });
    }
}
