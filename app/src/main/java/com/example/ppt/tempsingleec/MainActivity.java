package com.example.ppt.tempsingleec;

import com.example.ppt.temp_coer.activitys.PorxyActivity;
import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_coer.tempDalegate;
import com.example.ppt.temp_ec.launcher.LauncherDalegate;

public class MainActivity extends PorxyActivity {

    @Override
    public MikeDalegate setRootDalegate() {
        return new ExampleDalegate();
    }
}
