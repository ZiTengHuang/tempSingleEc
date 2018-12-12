package com.example.ppt.temp_coer.net.callback;

import android.os.Handler;

import com.example.ppt.temp_coer.ui.loader.LoaderStyle;
import com.example.ppt.temp_coer.ui.loader.MikeLoading;
import com.example.ppt.temp_coer.utils.dialog.tipdialog.TipDialogCreator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestCallBack implements Callback<String> {

    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IRequest REQUEST;
    private final IFailure FAILURE;
    private final int LOADER_STYLE;
    private static final Handler HANDLER = new Handler();

    public RestCallBack(ISuccess success, IError error, IRequest request, IFailure failure, int loaderStyle) {
        this.SUCCESS = success;
        this.ERROR = error;
        this.REQUEST = request;
        this.FAILURE = failure;
        this.LOADER_STYLE = loaderStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            //判断call执行
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.message(), response.code());
            }
        }
        stopLoader();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
        stopLoader();
    }

    private void stopLoader() {
        if (LOADER_STYLE > 0) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                        TipDialogCreator.stopTipDialog();
                }
            }, 1000);
        }
    }
}
