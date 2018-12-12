package com.example.ppt.tempsingleec;

import com.example.ppt.temp_coer.activitys.PorxyActivity;
import com.example.ppt.temp_coer.dalegates.MikeDalegate;
import com.example.ppt.temp_ec.luancher.luancherDalegate;

public class MainActivity extends PorxyActivity {

    @Override
    public MikeDalegate setRootDalegate() {
        return new ExampleDalegate();
    }
}
