package com.example.ppt.temp_coer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.utils.dialog.tipdialog.TipDialogCreator;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import butterknife.OnClick;

public class tempDalegate extends MikeDalegate {


    @Override
    public Object setLayout() {
        return R.layout.temp_daltegate;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @OnClick(R2.id.temp_id)
    public void tempOncklick() {
        TipDialogCreator.showTipDailogLoading(getContext());
    }
}
