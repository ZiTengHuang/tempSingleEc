package com.example.ppt.temp_coer.utils.time;

import java.util.TimerTask;

public class BaseTimeTask extends TimerTask {

    private ITimeListener timeListener;

    public BaseTimeTask(ITimeListener iTimeListener) {
        this.timeListener = iTimeListener;
    }

    @Override
    public void run() {
        if (timeListener != null) {
            timeListener.onTime();
        }
    }
}
