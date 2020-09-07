package com.chaolemen.ergedd.hear.model;

import com.chaolemen.ergedd.hear.bean.TabHearBean;
import com.chaolemen.ergedd.hear.contract.TabHearContract;
import com.chaolemen.ergedd.net.ErgeddHttpCallBack;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class TabHearModel implements TabHearContract.Model {
    @Override
    public void getDataTabHear(String channel, final TabHearContract.TabCallBack tabCallBack, LifecycleProvider lifecycleProvider) {

        HashMap<String, Object> ParameterMap = new HashMap<>();
        ParameterMap.put("channel", channel);

        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/audio_categories")
                .setParamser(ParameterMap)
                .setLifecycleProvider(lifecycleProvider)
                .build()
                .request(new ErgeddHttpCallBack<List<TabHearBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        tabCallBack.onFail(message + code);
                    }

                    @Override
                    public void cancle() {
                        tabCallBack.onCancel();
                    }

                    @Override
                    public void onSuccess(List<TabHearBean> tabBeans) {
                        tabCallBack.onSuccessHear(tabBeans);
                    }

                    @Override
                    public List<TabHearBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, TabHearBean.class);
                    }
                });

    }
}
