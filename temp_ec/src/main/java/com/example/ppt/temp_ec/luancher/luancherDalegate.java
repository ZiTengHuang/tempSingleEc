package com.example.ppt.temp_ec.luancher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.ppt.temp_coer.app.Mike;
import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.utils.app.APKVersionCodeUtils;
import com.example.ppt.temp_coer.utils.storage.PptPreference;
import com.example.ppt.temp_coer.utils.time.BaseTimeTask;
import com.example.ppt.temp_coer.utils.time.ITimeListener;
import com.example.ppt.temp_coer.utils.toast.ToastCreator;
import com.example.ppt.temp_ec.R;
import com.example.ppt.temp_ec.R2;
import com.example.ppt.temp_ec.sign.SignInDelegate;

import java.text.MessageFormat;
import java.util.Timer;
import butterknife.BindView;
import butterknife.OnClick;

public class luancherDalegate extends MikeDalegate implements ITimeListener {
    @BindView(R2.id.tv_luancher_timer)
    AppCompatTextView tvLuancherTimer;
    private Timer mTimer = null;
    private int mCount = 5;

    @Override
    public Object setLayout() {
        return R.layout.dalegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    private void initTimer() {
        mTimer = new Timer();
        BaseTimeTask timeTask = new BaseTimeTask(this);
        mTimer.schedule(timeTask, 0, 1000);
    }

    @Override
    public void onTime() {
        getPorxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTimer != null) {
                    tvLuancherTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount == 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScoll();
                        }
                    }
                }
            }
        });
    }

    private void checkIsShowScoll() {
        final int vsCode = APKVersionCodeUtils.getVersionCode(Mike.getApplicationContext());
        if (!PptPreference.getCustomAppProfile("vsCode").equals("")){
        if (vsCode > Integer.parseInt(PptPreference.getCustomAppProfile("vsCode"))) {
            ToastCreator.showToast("当前版本比历史版本高要跳");
        } else {
            ToastCreator.showToast("当前版本比历史版本低或者一样");
        }
        PptPreference.addCustomAppProfile("vsCode", APKVersionCodeUtils.getVersionCode(Mike.getApplicationContext()) + "");
         }else {
            ToastCreator.showToast("当前版本比历史版本高要跳");
            PptPreference.addCustomAppProfile("vsCode", APKVersionCodeUtils.getVersionCode(Mike.getApplicationContext()) + "");
        }
        start(new SignInDelegate(), SINGLETASK);
    }

    @OnClick(R2.id.tv_luancher_timer)
    public void onTimerClick() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScoll();
        }
    }
}
