package thedev.taqi.userlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import thedev.taqi.userlogin.commons.SessionManager;

public class SplashScreen extends Activity {


    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInpubstanceState) {
        super.onCreate(savedInpubstanceState);
        setContentView(R.layout.splashxml);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                Intent intent;
                if (SessionManager.isLoggedIn(SplashScreen.this))
                    intent = new Intent(SplashScreen.this, BasicInfoPage.class);
                else
                    intent = new Intent(SplashScreen.this, LoginActivity2.class);
                startActivity(intent);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);


    }
}


