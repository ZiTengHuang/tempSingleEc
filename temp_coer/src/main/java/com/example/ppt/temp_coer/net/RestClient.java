package com.example.ppt.temp_coer.net;


import android.content.Context;
import android.text.TextUtils;

import com.example.ppt.temp_coer.net.callback.IError;
import com.example.ppt.temp_coer.net.callback.IFailure;
import com.example.ppt.temp_coer.net.callback.IRequest;
import com.example.ppt.temp_coer.net.callback.ISuccess;
import com.example.ppt.temp_coer.net.callback.RestCallBack;
import com.example.ppt.temp_coer.net.download.DownloadHandler;
import com.example.ppt.temp_coer.utils.dialog.tipdialog.TipDialogCreator;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * 请求具体实现类
 */
public class RestClient {

    //因为要一次构建完毕不允许更改 所以使用final final 最好是用大写

    private final String URL;
    private final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String FILENAME;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IRequest REQUEST;
    private final IFailure FAILURE;
    private final RequestBody REQUESTBODY;
    private final int LOADER_STYLE;
    private final Context CONTEXT;
    private final String LOADER_MSG;
    private final File FILE;

    public RestClient(String url,
                      WeakHashMap<String, Object> params,
                      String download_dir,
                      String extension,
                      String filename,
                      ISuccess success,
                      IError error,
                      IRequest request,
                      IFailure failure,
                      RequestBody requestbody,
                      int loaderStyle,
                      Context context,
                      String loader_msg,
                      File file) {
        URL = url;
        DOWNLOAD_DIR = download_dir;
        EXTENSION = extension;
        FILENAME = filename;
        FILE = file;
        PARAMS.putAll(params);
        SUCCESS = success;
        ERROR = error;
        REQUEST = request;
        FAILURE = failure;
        REQUESTBODY = requestbody;
        LOADER_STYLE = loaderStyle;
        CONTEXT = context;
        LOADER_MSG = loader_msg;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }


    private void request(HttpMethod method) {
        final RestService restService = RestCreator.getRestService();
        Call<String> call = null;
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        if (LOADER_MSG != null || !TextUtils.isEmpty(LOADER_MSG)) {
            TipDialogCreator.showTipDailogLoading(CONTEXT, LOADER_STYLE, LOADER_MSG);
        } else if (!TextUtils.isEmpty(LOADER_MSG)) {
            TipDialogCreator.showTipDailogLoading(CONTEXT, LOADER_MSG);
        } else {
            TipDialogCreator.showTipDailogLoading(CONTEXT, LOADER_STYLE);
        }
        switch (method) {
            case GET:
                call = restService.get(URL, PARAMS);
                break;
            case POST:
                call = restService.post(URL, PARAMS);
                break;
            case PUT:
                call = restService.put(URL, PARAMS);
                break;
            case POST_RAW:
                call = restService.postRaw(URL, REQUESTBODY);
                break;
            case PUT_RAW:
                call = restService.putRaw(URL, REQUESTBODY);
                break;
            case UPLOAD:
                final RequestBody requestBody = RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body = MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                call = RestCreator.getRestService().upload(URL, body);
                break;
            case DELETE:
                call = restService.delete(URL, PARAMS);
                break;
            default:
                break;
        }
        if (call != null) {
            call.enqueue(getRequestCallBack());
        }

    }

    private Callback<String> getRequestCallBack() {
        return new RestCallBack(SUCCESS, ERROR, REQUEST, FAILURE, LOADER_STYLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        if (REQUESTBODY == null) {
            request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.POST_RAW);
        }

        request(HttpMethod.POST);
    }

    public final void put() {
        if (REQUESTBODY == null) {
            request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.PUT_RAW);
        }

        request(HttpMethod.POST);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void upload() {
        request(HttpMethod.UPLOAD);
    }

    public final void download() {
        new DownloadHandler(URL, DOWNLOAD_DIR, EXTENSION, FILENAME, SUCCESS, ERROR, REQUEST, FAILURE).handleDownload();

    }
}
