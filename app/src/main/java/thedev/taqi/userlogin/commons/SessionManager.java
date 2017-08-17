package thedev.taqi.userlogin.commons;

import android.content.Context;

public class SessionManager {


    private SessionManager() {

    }


    //eventbus responce recieve
    public static boolean isLoggedIn(Context context) {
        return Pref.getPreference(context, Pref.KEY_LOGGEDIN);
    }


    public static void logout(Context context) {
        Pref.clear(context);
    }
}