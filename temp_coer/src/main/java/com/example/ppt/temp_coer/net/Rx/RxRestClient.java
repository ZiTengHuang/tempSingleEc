package com.example.ppt.temp_coer.net.Rx;
import android.content.Context;
import android.text.TextUtils;
import com.example.ppt.temp_coer.net.HttpMethod;
import com.example.ppt.temp_coer.net.RestCreator;
import com.example.ppt.temp_coer.utils.dialog.tipdialog.TipDialogCreator;
import java.io.File;
import java.util.WeakHashMap;
import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
/**
 * 请求具体实现类
 */
public class RxRestClient {
    //因为要一次构建完毕不允许更改 所以使用final final 最好是用大写
    private final String URL;
    private final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final RequestBody REQUESTBODY;
    private final int LOADER_STYLE;
    private final Context CONTEXT;
    private final String LOADER_MSG;
    private final File FILE;

    public RxRestClient(String url,
                        WeakHashMap<String, Object> params,
                        RequestBody requestbody,
                        int loaderStyle,
                        Context context,
                        String loader_msg,
                        File file) {
        URL = url;
        FILE = file;
        PARAMS.putAll(params);
        REQUESTBODY = requestbody;
        LOADER_STYLE = loaderStyle;
        CONTEXT = context;
        LOADER_MSG = loader_msg;
    }

    public static RxRestClientBuilder builder() {
        return new RxRestClientBuilder();
    }


    private Observable<String> request(HttpMethod method) {
        final RxRestService restService = RestCreator.getRxRestService();
        if (LOADER_MSG != null || !TextUtils.isEmpty(LOADER_MSG)) {
            TipDialogCreator.showTipDailogLoading(CONTEXT, LOADER_STYLE, LOADER_MSG);
        } else if (!TextUtils.isEmpty(LOADER_MSG)) {
            TipDialogCreator.showTipDailogLoading(CONTEXT, LOADER_MSG);
        } else {
            TipDialogCreator.showTipDailogLoading(CONTEXT, LOADER_STYLE);
        }
        Observable<String> observable = null;
        switch (method) {
            case GET:
                observable = restService.get(URL, PARAMS);
                break;
            case POST:
                observable = restService.post(URL, PARAMS);
                break;
            case PUT:
                observable = restService.put(URL, PARAMS);
                break;
            case POST_RAW:
                observable = restService.postRaw(URL, REQUESTBODY);
                break;
            case PUT_RAW:
                observable = restService.putRaw(URL, REQUESTBODY);
                break;
            case UPLOAD:
                final RequestBody requestBody = RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body = MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                observable = RestCreator.getRxRestService().upload(URL, body);
                break;
            case DELETE:
                observable = restService.delete(URL, PARAMS);
                break;
            default:
                break;
        }
        return observable;
    }


    public final Observable<String> get() {
      return   request(HttpMethod.GET);
    }

    public final Observable<String> post() {
        if (REQUESTBODY == null) {
            return  request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            return  request(HttpMethod.POST_RAW);
        }
    }

    public final Observable<String> put() {
        if (REQUESTBODY == null) {
            return   request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            return  request(HttpMethod.PUT_RAW);
        }
     }

    public final Observable<String> delete() {
        return request(HttpMethod.DELETE);
    }

    public final Observable<String> upload() {
        return  request(HttpMethod.UPLOAD);
    }

    public final Observable<ResponseBody> download() {
        return  RestCreator.getRxRestService().download(URL, PARAMS);
    }
}
