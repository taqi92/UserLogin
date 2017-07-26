package thedev.taqi.userlogin.networking;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import thedev.taqi.userlogin.events.LoginEvent;

/**
 * Created by HP on 7/25/2017.
 */

public final class ApiClient {

    // private constructor
    private ApiClient(){
    }

    public static void login(Context context, final String email, String password){
        AndroidNetworking.post(ApiEndpoints.BASE_URL+ApiEndpoints.ENDPOINT_LOGIN)
                .addBodyParameter("tag", "login")
                .addBodyParameter("email", email)
                .addBodyParameter("password", password)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response

                        Log.i("LOGIN_RESPONSE","Initiated");
                        Log.i("LOGIN_RESPONSE",response.toString());
                        EventBus.getDefault().post(new LoginEvent(response,email));

                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.i("LOGIN_ERROR","Error");
                        Log.i("LOGIN_ERROR",error.getErrorDetail());

                    }
                });
    }


    public static void getResources(Context context){
        AndroidNetworking.post(ApiEndpoints.BASE_URL2+ApiEndpoints.ENDPOINT_INFO)
                .addBodyParameter("tag", "getData")
                .setTag("test2")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {


                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.i("LOGIN_ERROR","Error");
                        Log.i("LOGIN_ERROR",error.getErrorDetail());

                    }
                });
    }

}
