package com.chaolemen.ergedd.look.model;

import com.chaolemen.ergedd.look.bean.SItemBean;
import com.chaolemen.ergedd.look.contract.SiftItemContract;
import com.chaolemen.ergedd.net.ErgeddHttpCallBack;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

public class SiftItemModel implements SiftItemContract.Model {
    @Override
    public void getDataSift(int id, SiftItemContract.SiftItemCallBack siftItemCallBack, LifecycleProvider lifecycleProvider) {

        new HttpClient.Builder()
                .get()
                .setApiUrl("/api/v1/videos/id/play_info?quality=hd")
                .setLifecycleProvider(lifecycleProvider)
                .build()
                .request(new ErgeddHttpCallBack<SItemBean>() {
                    @Override
                    public void onError(String message, int code) {
                        siftItemCallBack.onFail(message+code);
                    }

                    @Override
                    public void cancle() {
                        siftItemCallBack.onCancel();
                    }

                    @Override
                    public void onSuccess(SItemBean sItemBean) {
                        siftItemCallBack.onSuccessSiftItem(sItemBean);
                    }

                    @Override
                    public SItemBean convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result,SItemBean.class);
                    }
                });
    }
}
