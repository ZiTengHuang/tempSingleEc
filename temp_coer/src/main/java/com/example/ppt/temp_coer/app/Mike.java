package com.example.ppt.temp_coer.app;

import android.content.Context;
import android.os.Handler;

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

    public static Handler getHandler() {
        return  getConfiguration(ConfigKeys.HANDLER);

    }

}
