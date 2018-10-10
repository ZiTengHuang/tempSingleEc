package com.example.ppt.temp_coer.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

public class Configuratro {


    private static final HashMap<String, Object> CONFIGS = new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configuratro() {
        initIcons();
        CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    final HashMap<String, Object> getConfigs() {
        return CONFIGS;
    }

    public static Configuratro getInstence() {
        return Holder.INSTENCE;
    }

    private static final class Holder {
        private static final Configuratro INSTENCE = new Configuratro();
    }

    public final Configuratro withHost(String host) {
        CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    public final void configure() {
        CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) CONFIGS.get(ConfigType.CONFIG_READY);
        if (isReady) {
            throw new RuntimeException("还没配置完成");
        }
    }

    private void initIcons() {
        if (ICONS.size() >= 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configuratro withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }


    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(value + "is null");
        }
        return (T) CONFIGS.get(key);
    }
}
