package com.meigsmart.meiglibs.install;

import com.alibaba.fastjson.JSON;
import com.meigsmart.meiglibs.http.config.RequestCode;
import com.meigsmart.meiglibs.http.rxjava.observer.BaseObserver;
import com.meigsmart.meiglibs.http.service.HttpManager;
import com.meigsmart.meiglibs.model.ClientsModel;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenMeng on 2017/11/21.
 */

public class SDKInit implements SDKApi {

    @Override
    public void login(@NonNull String token, @NonNull String lang, @NonNull String bundle_id, @NonNull String name, @NonNull final RequestResult rr) {
        Map<String, Object> map = new HashMap<>();
        map.put(RequestCode.KEY_TOKEN, token);
        map.put(RequestCode.KEY_LANG, lang);
        map.put(RequestCode.KEY_BUNDLE_ID, bundle_id);
        map.put(RequestCode.KEY_NAME, name);

        HttpManager.getApiService()
                .registerApp(HttpManager.getParameter(JSON.toJSONString(map)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<ClientsModel>() {
                    @Override
                    public void onError(Throwable e) {
                        rr.onError(e);
                    }
                    @Override
                    protected void onSuccess(ClientsModel model) {
                        rr.onSuccess(model);
                    }
                });
    }

    @Override
    public void registerApp(String token, String lang, String bundle_id, String name, final RequestResult rr) {
        Map<String, Object> map = new HashMap<>();
        map.put(RequestCode.KEY_TOKEN, token);
        map.put(RequestCode.KEY_LANG, lang);
        map.put(RequestCode.KEY_BUNDLE_ID, bundle_id);
        map.put(RequestCode.KEY_NAME, name);

        HttpManager.getApiService()
                .registerApp(HttpManager.getParameter(JSON.toJSONString(map)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<ClientsModel>() {
                    @Override
                    public void onError(Throwable e) {
                        rr.onError(e);
                    }
                    @Override
                    protected void onSuccess(ClientsModel model) {
                        rr.onSuccess(model);
                    }
                });
    }
}
