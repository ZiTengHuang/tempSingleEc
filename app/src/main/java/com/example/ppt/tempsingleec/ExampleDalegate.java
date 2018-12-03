package com.example.ppt.tempsingleec;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.ppt.temp_coer.R2;
import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.net.RestClient;
import com.example.ppt.temp_coer.net.api.Constants;
import com.example.ppt.temp_coer.net.callback.IError;
import com.example.ppt.temp_coer.net.callback.ISuccess;
import com.example.ppt.temp_coer.utils.toast.ToastCreator;
import com.example.ppt.temp_ec.test.BasicTestDalegate;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;


public class ExampleDalegate extends MikeDalegate {


    @BindView(R2.id.temp_id)
    Button tempOncklick;

    @Override
    public Object setLayout() {
        return R.layout.temp_daltegate;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        ToastCreator.showToast("666666666");
        RestClient.builder()
                .url(Constants.WEBINDEX)
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Logger.i(response);
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(String msg, int code) {
                        Logger.i(msg + "===============" + code);
                    }
                })
                .builder()
                .get();
    }

    @OnClick(R2.id.temp_id)
    public void setTempOncklick() {

    }

    @OnClick(R2.id.yueshu_id)
    public void yueshuonclick() {
        start(new BasicTestDalegate(), SINGLETASK);
    }
}

