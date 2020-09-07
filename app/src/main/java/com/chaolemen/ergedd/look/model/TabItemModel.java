package com.chaolemen.ergedd.look.model;

import com.chaolemen.ergedd.look.bean.TabBean;
import com.chaolemen.ergedd.look.bean.TabItemBean;
import com.chaolemen.ergedd.look.contract.TabItemContract;
import com.chaolemen.ergedd.look.parmasen.TabParameter;
import com.chaolemen.ergedd.net.ErgeddHttpCallBack;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class TabItemModel implements TabItemContract.Model {
    @Override
    public void getDataTabItem(int id, TabParameter tabParameter, final TabItemContract.TabItemCallBack tabItemCallBack, LifecycleProvider lifecycleProvider) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("offset", tabParameter.getOffset());
        hashMap.put("limit", tabParameter.getLimit());
        hashMap.put("addition_album_count", tabParameter.getAddition_album_count());
        hashMap.put("channel", tabParameter.getChannel());

        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/albums/"+id+"/videos")
                .setParamser(hashMap)
                .setLifecycleProvider(lifecycleProvider)
                .build()
                .request(new ErgeddHttpCallBack<List<TabItemBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        LogUtils.e(message + code);
                        tabItemCallBack.onFail(message+ code);
                    }

                    @Override
                    public void cancle() {
                        tabItemCallBack.onCancel();
                    }

                    @Override
                    public void onSuccess(List<TabItemBean> tabBeans) {
                        LogUtils.e(tabBeans.toString());
                        tabItemCallBack.onSuccessTabItem(tabBeans);
                    }

                    @Override
                    public List<TabItemBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, TabItemBean.class);
                    }
                });
    }
}
