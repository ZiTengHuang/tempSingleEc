package com.example.ppt.temp_coer.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.util.ArrayList;
import java.util.HashMap;

public class Configurator {

    private static final HashMap<Object, Object> TEMP_CONFIGS = new HashMap<>();


    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();


    private Configurator() {
        TEMP_CONFIGS.put(ConfigKeys.TEMP_READY, false);
    }


    public static final Configurator getInstence() {
        return ConfiguratorHolder.INSTENCE;
    }


    private static final class ConfiguratorHolder {
        private static final Configurator INSTENCE = new Configurator();
    }


    public final HashMap<Object, Object> getTempConfigs() {
        return TEMP_CONFIGS;
    }


    public final void configurator(){
        TEMP_CONFIGS.put(ConfigKeys.TEMP_READY,true);
        initIcons();
    }

    public final Configurator withApiHost(String apiHost) {
        TEMP_CONFIGS.put(ConfigKeys.API_HOST, apiHost);
        return this;
    }

    private final void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor icon) {
        ICONS.add(icon);
        return this;
    }

    public final Configurator withLogger(LogAdapter logger){
          Logger.addLogAdapter(logger);
   return this;
    }

    private final void checkConfiguration(){
        final  boolean isRead = (boolean) TEMP_CONFIGS.get(ConfigKeys.TEMP_READY);
        if (!isRead){
             throw  new RuntimeException("还没配置好");
        }
    }
    /**
     * 提供key获取值
     */
    public <T> T getConfigurations(Object key){
        checkConfiguration();
        final Object value =  TEMP_CONFIGS.get(key);
        if (value == null){
              throw  new NullPointerException("参数为空");
        }
        return (T) TEMP_CONFIGS.get(key);
    }
}
