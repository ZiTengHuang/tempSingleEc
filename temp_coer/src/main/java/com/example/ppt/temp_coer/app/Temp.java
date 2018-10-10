package com.example.ppt.temp_coer.app;

import android.content.Context;

import java.util.HashMap;

public final class Temp {


    public static Configuratro init(Context context) {
        getConfigs().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configuratro.getInstence();
    }


    private static HashMap<String, Object> getConfigs() {
        return Configuratro.getInstence().getConfigs();
    }

    public static Context getApplicationContext() {
        return (Context) getConfigs().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
