package com.example.ppt.tempsingleec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.net.RestClient;
import com.example.ppt.temp_coer.net.Rx.RxRestClient;
import com.example.ppt.temp_coer.net.api.Constants;
import com.example.ppt.temp_coer.net.callback.IError;
import com.example.ppt.temp_coer.net.callback.ISuccess;
import com.example.ppt.temp_coer.utils.dialog.tipdialog.TipDialogCreator;
import com.orhanobut.logger.Logger;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ExampleDalegate extends MikeDalegate {



    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
         RestClient.builder()
                .url(Constants.LOGIN)
                 .params("username", "13049337194")
                 .params("userpass", "198541")
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
        RestClient.builder()
                .url(Constants.LOGIN)
                .params("username", "13049337194")
                .params("userpass", "198541")
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

        RestClient.builder()
                .url(Constants.LOGIN)
                .params("username", "13049337194")
                .params("userpass", "198541")
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

//        RestClient.builder()
//                .url(Constants.LOGIN)
//                .loader(getContext())
//
//                .params("username", "13049337194")
//                .params("userpass", "198541")
//                .success(new ISuccess() {
//                    @Override
//                    public void onSuccess(String response) {
//                        Logger.i(response);
//                    }
//                })
//                .error(new IError() {
//                    @Override
//                    public void onError(String msg, int code) {
//
//                    }
//                })
//
//                .builder()
//                .post();
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
}

