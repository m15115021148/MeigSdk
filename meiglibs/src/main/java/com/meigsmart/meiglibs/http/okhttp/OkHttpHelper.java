package com.meigsmart.meiglibs.http.okhttp;



import com.meigsmart.meiglibs.http.okhttp.interceptor.HeaderInterceptor;
import com.meigsmart.meiglibs.http.okhttp.interceptor.LogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * <p>Description:
 * <p>
 * <p>Created by chenmeng on 2017/9/4.
 */

public class OkHttpHelper {

    private static OkHttpClient okHttpClient;

    /**
     * 连接超时
     */
    private static final int CONNECT_TIMEOUT = 10;
    /**
     * 读取超时
     */
    private static final int READ_TIMEOUT = 25;
    /**
     * 写入超时
     */
    private static final int WRITE_TIMEOUT = 25;


    private OkHttpHelper() {
    }

    static {

        okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())  //请求信息的打印 ，可在 release 时关闭
                .addInterceptor(new HeaderInterceptor())
                .build();
    }

    public static OkHttpClient getClient() {
        return okHttpClient;
    }

}
