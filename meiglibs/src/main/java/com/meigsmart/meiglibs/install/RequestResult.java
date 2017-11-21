package com.meigsmart.meiglibs.install;

import com.meigsmart.meiglibs.model.BaseModel;

/**
 * Created by chenMeng on 2017/11/21.
 */

public abstract class RequestResult {
    public abstract void onError(Throwable e);
    public abstract void onSuccess(Object object);
}
