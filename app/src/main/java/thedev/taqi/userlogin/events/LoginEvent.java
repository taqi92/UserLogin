package thedev.taqi.userlogin.events;

import org.json.JSONObject;

/**
 * Created by HP on 7/25/2017.
 */

public class LoginEvent {
    private JSONObject response;
    private String email;

    public LoginEvent(JSONObject response,String email) {
        this.response = response;
        this.email = email;
    }

    public JSONObject getResponse() {
        return response;
    }

    public String getEmail() {
        return email;
    }
}
