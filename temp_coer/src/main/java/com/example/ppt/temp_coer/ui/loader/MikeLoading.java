package com.example.ppt.temp_coer.ui.loader;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;


import com.example.ppt.temp_coer.R;
import com.example.ppt.temp_coer.utils.dimen.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

public class MikeLoading {

    //缩放比例 让 loading 自动适应
    private static final int LOADING_SIZE_SCALE = 8;
    // loading 偏移量
    private static final int LOADING_OFFSET_SCALE = 10;

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();

     public static final LoaderStyle DEFAULT_LOADER = LoaderStyle.LineSpinFadeLoaderIndicator;

    public static void showLoading(Context context, String type) {

        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
        dialog.setContentView(avLoadingIndicatorView);

        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();

        // 创建window对象
        final Window dialogWindow = dialog.getWindow();

        if (dialogWindow != null) {
            WindowManager.LayoutParams layoutParams = dialogWindow.getAttributes();
            layoutParams.width = deviceWidth / LOADING_SIZE_SCALE;
            layoutParams.height = deviceHeight / LOADING_SIZE_SCALE;
            layoutParams.height = layoutParams.height + deviceHeight / LOADING_OFFSET_SCALE;
            layoutParams.gravity = Gravity.CENTER;
        }
        //创建一个集合统一管理loading 关闭的时候 遍历一一关闭就好了
        LOADERS.add(dialog);
        dialog.show();
    }

//  public static void showLoading(Context context) {
//  showLoading(context, DEFAULT_LOADER);
//  }

    public static void showLoading(Context context, Enum<LoaderStyle> type) {
        showLoading(context, type.name());
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                    dialog.dismiss();
                }
            }
        }
    }
}
