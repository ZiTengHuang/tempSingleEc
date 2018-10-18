package com.example.ppt.tempsingleec;

import com.example.ppt.temp_coer.activitys.ProxyActivity;
import com.example.ppt.temp_coer.dalegates.TempDalegate;

public class MainActivity extends ProxyActivity {
    @Override
    public TempDalegate setRootDalegate() {
        return new ExampleDalegate();
    }
}
