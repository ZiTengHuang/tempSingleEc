package com.example.ppt.tempsingleec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.ppt.temp_coer.R2;
import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_ec.test.BasicTestDalegate;
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
//         RestClient.builder()
//                .url(Constants.WEBINDEX)
//                .loader(getContext())
//                .success(new ISuccess() {
//                    @Override
//                    public void onSuccess(String response) {
//                        Logger.i(response);
//                    }
//                })
//                .error(new IError() {
//                    @Override
//                    public void onError(String msg, int code) {
//                        Logger.i(msg + "===============" + code);
//                    }
//                })
//                .builder()
//                .get();

//        RxRestClient.builder()
//                .url(Constants.WEBINDEX)
//                .loader(getContext())
//                .build()
//                .get()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Logger.i(s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

    }

    @OnClick(R2.id.temp_id)
    public void setTempOncklick() {

    }

    @OnClick(R2.id.yueshu_id)
    public void yueshuonclick() {
        start(new BasicTestDalegate(), SINGLETASK);
    }
}

