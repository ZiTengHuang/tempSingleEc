package com.example.ppt.temp_ec.icon;

import com.joanzapata.iconify.Icon;

public enum  TempIcons implements Icon {
    icon_message('\ue614'),
    icon_mail('\ue629'),
    icon_lock('\ue62b'),
    icon_loading('\ue62d'),
    icon_like('\ue62e'),
    icon_download('\ue631');

    char character;

    TempIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
