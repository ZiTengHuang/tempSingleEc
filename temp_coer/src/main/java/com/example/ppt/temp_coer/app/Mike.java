package com.example.ppt.temp_coer.app;

import android.app.Application;
import android.content.Context;

public class Mike {

    public static Configurator init(Context context) {
        getConfigurator()
                .getTempConfigs()
                .put(ConfigKeys.APPLICATION_CONTENT, context.getApplicationContext());
        return getConfigurator();
    }


    private static Configurator getConfigurator() {
        return Configurator.getInstence();
    }


    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfigurations(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTENT);
    }

}
