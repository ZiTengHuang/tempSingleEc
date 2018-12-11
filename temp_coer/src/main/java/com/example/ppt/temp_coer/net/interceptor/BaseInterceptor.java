package com.example.ppt.temp_coer.net.interceptor;

import java.io.IOException;
import java.util.LinkedHashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public abstract class BaseInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }

    /**
     * 获取get请求中参数
     *
     * @param chain
     * @return
     */
    protected LinkedHashMap<String, String> getUrlParameters(Chain chain) {
        final HttpUrl url = chain.request().url();   //获取请求的URL
        int size = url.querySize(); //获取请求参数的个数
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(url.queryParameterName(i), url.queryParameterValue(i)); //循环添加请求参数的键值对
        }
        return params;
    }



    /**
     * 根据key获取对应的请求值
     *
     * @param chain
     * @param key
     * @return
     */
    protected String getUrlParameters(Chain chain, String key) {
        final Request request = chain.request();
        return request.url().queryParameter(key);
    }

    /**
     * 获取post请求中的参数
     *
     * @param chain
     * @return
     */
    protected LinkedHashMap<String, String> getBodyParameters(Chain chain) {
        final FormBody formBody = (FormBody) chain.request().body();  //获取请求体
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        int size = formBody.size();
        for (int i = 0; i < size; i++) {
            params.put(formBody.name(i), formBody.value(i));
        }
        return params;
    }

    protected String getBodyParameters(Chain chain, String key) {
        return getBodyParameters(chain).get(key);
    }
}
