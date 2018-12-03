package com.example.ppt.temp_ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.utils.dialog.tipdialog.TipDialogCreator;
import com.example.ppt.temp_coer.utils.toast.ToastCreator;
import com.example.ppt.temp_ec.R;
import com.example.ppt.temp_ec.R2;

import butterknife.OnClick;

public class LauncherDalegate extends MikeDalegate {


    @Override
    public Object setLayout() {
        return R.layout.dalegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @OnClick(R2.id.tempbun)
    public void setTempbtnOncklick() {
        ToastCreator.showToast("出来？");
    }

    @OnClick(R2.id.tempbtn)
    public void setTempbunOncklick() {
        TipDialogCreator.showTipDailogLoading(getContext());
    }


}
