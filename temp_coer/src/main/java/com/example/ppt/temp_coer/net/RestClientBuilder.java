package com.example.ppt.temp_coer.net;

import android.content.Context;

import com.example.ppt.temp_coer.net.callback.IError;
import com.example.ppt.temp_coer.net.callback.IFailure;
import com.example.ppt.temp_coer.net.callback.IRequest;
import com.example.ppt.temp_coer.net.callback.ISuccess;
import com.example.ppt.temp_coer.utils.dialog.tipdialog.TipDialogCreator;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RestClientBuilder {
    private String mUrl = null;
    private WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private ISuccess mSuccess = null;
    private IError mError = null;
    private IRequest mRequest = null;
    private IFailure mFailure = null;
    private RequestBody mRequestBody = null;
    private int mLoderStyle = 0;
    private String mLoderMsg = null;
    private Context mContext = null;
    private File mFile = null;
    private String mDownloaddir = null;
    private String mExtension = null;
    private String mFilename = null;

    //构造方法不添加任何关键字，为默认关键字 只允许同包的来用
    RestClientBuilder() {

    }

    //构造者无非做一些传值的操作，可以不需要做改变  so 我们一般设置为final
    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mRequestBody = RequestBody.create(MediaType.parse("application/json:charset=UTF-8"), raw);
        return this;
    }


    public final RestClientBuilder dir(String dir) {
        this.mDownloaddir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final RestClientBuilder filename(String filename) {
        this.mFilename = filename;
        return this;
    }


    public final RestClientBuilder request(IRequest request) {
        this.mRequest = request;
        return this;
    }


    public final RestClientBuilder success(ISuccess success) {
        this.mSuccess = success;
        return this;
    }

    public final RestClientBuilder error(IError error) {
        this.mError = error;
        return this;
    }

    public final RestClientBuilder failure(IFailure failure) {
        this.mFailure = failure;
        return this;
    }

    public final RestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }


    public final RestClientBuilder loader(Context context, int loaderStyle) {
        this.mContext = context;
        this.mLoderStyle = loaderStyle;
        return this;
    }

    public final RestClientBuilder loader(Context context, String loderMsg) {
        this.mContext = context;
        this.mLoderMsg = loderMsg;
        this.mLoderStyle = TipDialogCreator.DEFAULT_ICON_TYPE_LOADING;
        return this;
    }

    public final RestClientBuilder loader(Context context, int loaderStyle, String loaderMsg) {
        this.mContext = context;
        this.mLoderStyle = loaderStyle;
        this.mLoderMsg = loaderMsg;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoderStyle = TipDialogCreator.DEFAULT_ICON_TYPE_LOADING;
        return this;
    }

    public RestClient builder() {
        return new RestClient(mUrl, PARAMS, mDownloaddir, mExtension, mFilename, mSuccess, mError, mRequest, mFailure, mRequestBody, mLoderStyle, mContext, mLoderMsg, mFile);
    }
}
