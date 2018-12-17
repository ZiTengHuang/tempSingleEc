package com.example.ppt.tempsingleec;

import com.example.ppt.temp_coer.activitys.PorxyActivity;
import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.utils.dialog.tipdialog.TipDialogCreator;
import com.example.ppt.temp_coer.utils.toast.ToastCreator;
import com.example.ppt.temp_ec.luancher.ILuancherListener;
import com.example.ppt.temp_ec.luancher.OnLancherFinishTag;
import com.example.ppt.temp_ec.luancher.luancherDalegate;
import com.example.ppt.temp_ec.main.EcBottomDelegate;
import com.example.ppt.temp_ec.sign.ISignListener;
import com.example.ppt.temp_ec.sign.SignInDelegate;

public class MainActivity extends PorxyActivity implements ISignListener, ILuancherListener {

    @Override
    public MikeDalegate setRootDalegate() {
        return new luancherDalegate();
    }


    @Override
    public void onSignInSuccess() {
        ToastCreator.showToast("登录成功");
        startWithPop(new EcBottomDelegate());

    }

    @Override
    public void onSignUpSuccess() {
        TipDialogCreator.showTipDailogLoading(this, "注册成功");
    }

    @Override
    public void onLuancherFinish(OnLancherFinishTag onLancherFinishTag) {
        switch (onLancherFinishTag) {
            case SIGNEN:
                TipDialogCreator.showTipDailogLoading(this, "启动完成已经登录");
                break;

            case NOT_SIGNEN:
                TipDialogCreator.showTipDailogLoading(this, "启动完成没有登录");
                break;
            default:
                break;

        }
    }
}
