package com.example.ppt.temp_coer.utils.dialog.tipdialog;

import android.content.Context;
import android.os.Handler;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

public class TipDialogCreator {


    private static QMUITipDialog tipDailog = null;

    private static final String WORK_MSG = "正在加载..";


    public static final int DEFAULT_ICON_TYPE_LOADING = QMUITipDialog.Builder.ICON_TYPE_LOADING;

    private static final Handler HANDLER = new Handler();

    /**
     * 显示加载框
     */
    public static void showTipDailogLoading(Context context, String msg) {
        tipDailog = new QMUITipDialog.Builder(context)
                .setIconType(DEFAULT_ICON_TYPE_LOADING)
                .setTipWord(msg)
                .create();
        tipDailog.show();
        stopDialog();
    }

    public static void showTipDailogLoading(Context context) {
        tipDailog = new QMUITipDialog.Builder(context)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord(WORK_MSG)
                .create();
        tipDailog.show();
    }

    public static void showTipDailogLoading(Context context, int type) {
        tipDailog = new QMUITipDialog.Builder(context)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord(WORK_MSG)
                .create();
        tipDailog.show();
    }

    public static void showTipDailogLoading(Context context, int type, String msg) {
        tipDailog = new QMUITipDialog.Builder(context)
                .setIconType(type)
                .setTipWord(msg)
                .create();
        tipDailog.show();
    }

    public static void stopTipDialog() {
        if (tipDailog.isShowing()) {
            tipDailog.dismiss();
            tipDailog.cancel();
        }
    }

    private static void stopDialog() {
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                stopTipDialog();
            }
        }, 1500);
    }
}
