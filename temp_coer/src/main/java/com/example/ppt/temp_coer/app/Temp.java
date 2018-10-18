package com.example.ppt.temp_coer.app;

import android.content.Context;

import java.util.HashMap;

public final class Temp {

    public static Configuratro init(Context context) {
        getConfiguration().getInstence().getConfigs().put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configuratro.getInstence();
    }


    public static <T> T getConfigurations(Object key) {
        return getConfiguration().getConfiguration(key);
    }

    private static Configuratro getConfiguration() {
        return Configuratro.getInstence();
    }

    public static Context getApplicationContext() {
        return getConfigurations(ConfigType.APPLICATION_CONTEXT);
    }
}
