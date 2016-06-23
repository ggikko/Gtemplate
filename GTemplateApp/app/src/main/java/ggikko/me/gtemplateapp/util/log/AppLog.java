package ggikko.me.gtemplateapp.util.log;

import android.util.Log;

import ggikko.me.gtemplateapp.GgikkoApplication;

/**
 * Created by admin on 16. 6. 23..
 */
public class AppLog {

    public static final boolean SHOULD_LOG = true;//BuildConfig.DEBUG;

    public static void d(String message) {
        if (SHOULD_LOG) {
            Log.d(GgikkoApplication.class.getPackage().getName(), message);
        }
    }

    public static void e(Throwable error) {
        if (SHOULD_LOG) {
            Log.e(GgikkoApplication.class.getPackage().getName(), "Error", error);
        }
    }
}
