package thedev.taqi.userlogin.commons;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HP on 7/25/2017.
 */

public class Pref {
    public static final String PREF_NAME = "APP_PREF_767";
    public static final String KEY_LOGGEDIN = "isLoggedIn";
    public static final String KEY_EMAIL = "email";

    public static void savePreference(Context context, String key, boolean value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sharedPref.edit();

        prefEditor.putBoolean(key, value);
        prefEditor.apply();
    }

    public static boolean getPreference(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPref.getBoolean(key, false);
    }

    public static void savePreference(Context context, String key, int value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sharedPref.edit();

        prefEditor.putInt(key, value);
        prefEditor.apply();

    }

    public static int getPreferenceInt(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPref.getInt(key, 0);
    }

    public static void savePreference(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sharedPref.edit();

        prefEditor.putString(key, value);
        prefEditor.apply();
    }

    public static String getPreferenceString(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPref.getString(key, "");
    }


    public static boolean isNull(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPref.contains(key))
            return false;
        return true;
    }

    public static void clear(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();
    }
}

