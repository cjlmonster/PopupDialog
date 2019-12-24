package main.cjl.com.util;

import android.content.Context;

public class DpUtils {

    public static int dpToPx(Context context, float value) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (value * scale + 0.5f);
    }

    public static int pxToDp(Context context, float value) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (value / scale + 0.5f);
    }
}
