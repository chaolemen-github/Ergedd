package com.chaolemen.ergedd.net;

import android.util.Log;

import com.chaolemen.ergedd.bean.ErgeddRespoense;
import com.chaolemen.ergedd.utils.SpUtil;
import com.chaolemen.httplibrary.callback.BaseCallBack;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public
abstract
class ErgeddHttpCallBack<T> extends BaseCallBack<T> {
    ErgeddRespoense ergeddRespoense;

    @Override
    protected T onConvert(String result) {
        T t = null;
        LogUtils.e("callback" + result);
        ergeddRespoense = new Gson().fromJson(result, ErgeddRespoense.class);
        LogUtils.e("callback1" + ergeddRespoense.toString());
        boolean errorCode = ergeddRespoense.isSuccess();
        String message = ergeddRespoense.getMessage();
        JsonElement data = ergeddRespoense.getData();
        if (!errorCode) {
            onError(message, -1);
            SpUtil.clear();
        } else {
            if (isCodeSuccess()) {
                t = convert(data);
            }
        }
        Log.e("clm", "onConvert: " + t.toString());
        return t;
    }

    @Override
    public boolean isCodeSuccess() {
        if (ergeddRespoense != null) {
            return ergeddRespoense.isSuccess()==true;
        }
        return false;
    }


}
