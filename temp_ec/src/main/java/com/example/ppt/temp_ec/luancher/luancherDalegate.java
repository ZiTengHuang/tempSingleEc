package com.example.ppt.temp_ec.luancher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.utils.time.BaseTimeTask;
import com.example.ppt.temp_coer.utils.time.ITimeListener;
import com.example.ppt.temp_ec.R;
import com.example.ppt.temp_ec.R2;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

public class luancherDalegate extends MikeDalegate implements ITimeListener {
    @BindView(R2.id.tv_luancher_timer)
    AppCompatTextView tvLuancherTimer;
    @Override
    public Object setLayout() {
        return R.layout.dalegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    private void initTimer() {
        Timer timer = new Timer();
        BaseTimeTask timeTask = new BaseTimeTask(this);
        timer.schedule(timeTask,0,1000);
     }

    @Override
    public void onTime() {

    }

    @OnClick(R2.id.tv_luancher_timer)
    private void onTimerClick(){

    }
}
