package com.example.ppt.temp_coer.net.download;

import android.os.AsyncTask;

import com.example.ppt.temp_coer.net.RestCreator;
import com.example.ppt.temp_coer.net.callback.IError;
import com.example.ppt.temp_coer.net.callback.IFailure;
import com.example.ppt.temp_coer.net.callback.IRequest;
import com.example.ppt.temp_coer.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadHandler {
    private final String URL;
    private final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String FILENAME;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IRequest REQUEST;
    private final IFailure FAILURE;

    public DownloadHandler(String url,
                           String download_dir,
                           String extension,
                           String filename,
                           ISuccess success,
                           IError error,
                           IRequest request,
                           IFailure failure) {
        URL = url;
        DOWNLOAD_DIR = download_dir;
        EXTENSION = extension;
        FILENAME = filename;
        SUCCESS = success;
        ERROR = error;
        REQUEST = request;
        FAILURE = failure;
    }

    public final void handleDownload() {
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        RestCreator.getRestService().download(URL, PARAMS).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                final ResponseBody responseBody = response.body();

                final SaveFileTask saveFileTask = new SaveFileTask(SUCCESS, REQUEST);
                saveFileTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, DOWNLOAD_DIR, EXTENSION, responseBody, FILENAME);
                //一定要判断asynctask是否结束了，否则会文件下载不全
                if (saveFileTask.isCancelled()) {
                    if (REQUEST != null) {
                        REQUEST.onRequestEnd();
                    }
                } else {
                    if (ERROR != null) {
                        ERROR.onError(response.message(), response.code());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (FAILURE != null) {
                    FAILURE.onFailure();
                }
            }
        });
    }
}
