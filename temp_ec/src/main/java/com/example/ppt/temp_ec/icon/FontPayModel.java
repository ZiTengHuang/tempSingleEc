package com.example.ppt.temp_ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

public class FontPayModel implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        return "pay.ttf";
    }

    @Override
    public Icon[] characters() {
        return TempIcons.values();
    }
}
