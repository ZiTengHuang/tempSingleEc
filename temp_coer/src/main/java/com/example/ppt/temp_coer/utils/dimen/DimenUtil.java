package com.example.ppt.temp_coer.utils.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

 import com.example.ppt.temp_coer.app.Mike;

public class DimenUtil {

    /**
     * @return 屏幕的宽
     */
    public static int getScreenWidth() {
        final Resources resources = Mike.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * @return 屏幕的高
     */
    public static int getScreenHeight() {
        final Resources resources = Mike.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
 }

