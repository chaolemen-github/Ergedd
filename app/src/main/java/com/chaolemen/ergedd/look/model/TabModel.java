package com.chaolemen.ergedd.look.model;

import com.chaolemen.ergedd.look.bean.TabBean;
import com.chaolemen.ergedd.look.contract.TabContract;
import com.chaolemen.ergedd.look.parmasen.TabParameter;
import com.chaolemen.ergedd.net.ErgeddHttpCallBack;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class TabModel implements TabContract.Model {
    @Override
    public void getDataLook(TabParameter tabParameter, final TabContract.TabCallBack tabCallBack, LifecycleProvider lifecycleProvider) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("offset", tabParameter.getOffset());
        hashMap.put("limit", tabParameter.getLimit());
        hashMap.put("addition_album_count", tabParameter.getAddition_album_count());
        hashMap.put("channel", tabParameter.getChannel());

        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/album_categories")
                .setParamser(hashMap)
                .setLifecycleProvider(lifecycleProvider)
                .build()
                .request(new ErgeddHttpCallBack<List<TabBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        LogUtils.e(message + code);
                        tabCallBack.onFailLook(message, code);
                    }

                    @Override
                    public void cancle() {
                        tabCallBack.onCancel();
                    }

                    @Override
                    public void onSuccess(List<TabBean> tabBeans) {
                        LogUtils.e(tabBeans.toString());
                        tabCallBack.onSuccessLook(tabBeans);
                    }

                    @Override
                    public List<TabBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, TabBean.class);
                    }
                });
    }
}
