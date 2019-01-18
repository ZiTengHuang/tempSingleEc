package com.example.ppt.temp_ec.luancher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.ppt.temp_coer.app.AccountManager;
import com.example.ppt.temp_coer.app.IUserChecker;
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

/**
 * 过渡页
 */
public class luancherDalegate extends MikeDalegate implements ITimeListener {
    @BindView(R2.id.tv_luancher_timer)
    AppCompatTextView tvLuancherTimer;
    private Timer mTimer = null;
    private int mCount = 5;
    private ILuancherListener mILuancherListener = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILuancherListener) {
            mILuancherListener = (ILuancherListener) activity;
        }
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
        boolean isScroll = false;
        final int vsCode = APKVersionCodeUtils.getVersionCode(Mike.getApplicationContext());
        if (!PptPreference.getCustomAppProfile("vsCode").equals("")) {
            if (vsCode > Integer.parseInt(PptPreference.getCustomAppProfile("vsCode"))) {
                ToastCreator.showToast("当前版本比历史版本高要进入轮播图");
                isScroll = true;
            } else {
                ToastCreator.showToast("当前版本比历史版本低或者一样");
                isScroll = false;
            }
        } else {
            ToastCreator.showToast("第一次进入或者删除了APP，要进入轮播图");
            isScroll = true;
        }
        //判断是否登录过APP 登录过的话给一个进入后的登录方法。或者没登录方法
        if (!isScroll) {
            AccountManager.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    if (mILuancherListener != null) {
                        mILuancherListener.onLuancherFinish(OnLancherFinishTag.SIGNEN);
                    }
                }
                @Override
                public void onNotSignIn() {
                    if (mILuancherListener != null) {
                        mILuancherListener.onLuancherFinish(OnLancherFinishTag.NOT_SIGNEN);
                    }
                }
            });
        }
        PptPreference.addCustomAppProfile("vsCode", APKVersionCodeUtils.getVersionCode(Mike.getApplicationContext()) + "");
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
