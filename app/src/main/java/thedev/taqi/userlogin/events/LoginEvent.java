package thedev.taqi.userlogin.events;

import org.json.JSONObject;

/**
 * Created by HP on 7/25/2017.
 */

public class LoginEvent {
    private JSONObject response;

    public LoginEvent(JSONObject response) {
        this.response = response;
    }

    public JSONObject getResponse() {
        return response;
    }

}
