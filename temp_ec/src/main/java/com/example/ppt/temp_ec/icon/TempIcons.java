package com.example.ppt.temp_ec.icon;

import com.joanzapata.iconify.Icon;

public enum TempIcons implements Icon {
    icon_message('\ue614'),
    icon_mail('\ue629'),
    icon_lock('\ue62b'),
    icon_loading('\ue62d'),
    icon_like('\ue62e'),
    icon_download('\ue631'),
    icon_gouwuche('\u3475'),
    icon_faxian('\ue617'),
    icon_fenlei('\ue76f'),
    icon_wode('\ue603'),
    icon_scan('\ue60d'),
    icon_ali_pay('\ue64a'),
    icon_wex_pay('\ue622'),
    icon_zhuye('\ue609');

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
