package com.example.ppt.temp_coer.utils.toast;

import android.content.Context;
import android.graphics.Color;

import com.example.ppt.temp_coer.R;
import com.example.ppt.temp_coer.app.Mike;
import com.muddzdev.styleabletoast.StyleableToast;

/**
 * ToastStyle的封装
 */
public class ToastCreator {
    private static final Context context = Mike.getApplicationContext();

    private static StyleableToast TOAST;

    private static int redColor = Color.parseColor("#FF5A5F");

    /**
     * new StyleableToast.Builder(this)
     * .text(toastMsg)
     * .stroke(2, Color.CYAN)
     * .backgroundColor(Color.BLACK)
     * .solidBackground()
     * .textColor(Color.YELLOW)
     * .textBold()
     * .font(R.font.dosis)
     * .iconStart(R.drawable.ic_autorenew_black_24dp)
     * .iconEnd(R.drawable.ic_autorenew_black_24dp)
     * .cornerRadius(12)
     * .textSize(18)
     * .show();
     */

    private static final class HOLDER {
        private static final StyleableToast.Builder TOAST = new StyleableToast.Builder(context)
                .textColor(redColor)
                .stroke(2, Color.CYAN)
                .backgroundColor(Color.BLACK)
                .solidBackground()
                .textColor(Color.YELLOW)
                .textBold()
                .font(R.font.dosis)
                .iconStart(R.drawable.ic_autorenew_black_24dp)
                .iconEnd(R.drawable.ic_autorenew_black_24dp)
                .textSize(18);
    }


    public static void showToast(String msg) {
        HOLDER.TOAST.text(msg).show();
    }

    public static void showToast(String msg, int textcolor) {
        TOAST = StyleableToast.makeText(context, msg, textcolor);
    }


}
