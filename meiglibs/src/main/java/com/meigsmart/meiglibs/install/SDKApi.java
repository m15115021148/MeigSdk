package com.meigsmart.meiglibs.install;

import io.reactivex.annotations.NonNull;

/**
 * Created by chenMeng on 2017/11/21.
 */

public interface SDKApi {

    void login(String token, String lang, String bundle_id, String name, RequestResult rr);
    void registerApp(String token, String lang, String bundle_id, String name,RequestResult rr);
}
