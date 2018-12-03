package com.example.ppt.temp_coer.net.download;

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
          if (REQUEST!=null){
              REQUEST.onRequestStart();
          }
          RestCreator.getRestService().download(URL,PARAMS).enqueue(new Callback<ResponseBody>() {
              @Override
              public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

              }

              @Override
              public void onFailure(Call<ResponseBody> call, Throwable t) {

              }
          });
    }
}
