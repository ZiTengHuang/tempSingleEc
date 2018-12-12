package com.example.ppt.temp_coer.net.interceptor;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

public class TestInterceptor extends BaseInterceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        return response;
    }
}
