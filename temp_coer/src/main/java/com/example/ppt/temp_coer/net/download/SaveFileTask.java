package com.example.ppt.temp_coer.net.download;

import android.os.AsyncTask;

import com.example.ppt.temp_coer.net.callback.IError;
import com.example.ppt.temp_coer.net.callback.ISuccess;
import com.example.ppt.temp_coer.utils.file.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

public class SaveFileTask extends AsyncTask<Object, Void, File> {

    private final ISuccess SUCCESS;
    private final IError ERROR;

    public SaveFileTask(ISuccess success, IError error) {
        SUCCESS = success;
        ERROR = error;
    }

    @Override
    protected File doInBackground(Object... objects) {

        String downloadDir = (String) objects[0];
        String extension = (String) objects[1];
        final ResponseBody responseBody = (ResponseBody) objects[2];
        final String name = (String) objects[3];
        final InputStream inputStream = responseBody.byteStream();
        if (downloadDir == null || downloadDir.equals("")) {
            downloadDir = "down_load";
        }
        if (extension == null || extension.equals("")) {
            extension = "";
        }
        if (name == null) {
            return FileUtil.writeToDisk(inputStream, downloadDir, extension.toUpperCase(), extension);
        } else {
            return FileUtil.writeToDisk(inputStream, downloadDir, name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (SUCCESS != null) {
            SUCCESS.onSuccess(file.getPath());
        }
        if ()
    }
}
