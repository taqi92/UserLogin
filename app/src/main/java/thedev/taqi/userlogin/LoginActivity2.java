package thedev.taqi.userlogin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

import thedev.taqi.userlogin.commons.Pref;
import thedev.taqi.userlogin.events.LoginEvent;
import thedev.taqi.userlogin.networking.ApiClient;

public class LoginActivity2 extends AppCompatActivity {
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.txtEmail = (EditText) findViewById(R.id.txtEmail);
        this.txtPassword = (EditText) findViewById(R.id.txtPassword);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);

        // register events
        EventBus.getDefault().register(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidCredentials())
                    ApiClient.login(LoginActivity2.this, txtEmail.getText().toString(), txtPassword.getText().toString());
                else
                    Toast.makeText(LoginActivity2.this, "Credentials invalid", Toast.LENGTH_LONG).show();
            }
        });

    }



    @Subscribe
    public void onLoginPressed(LoginEvent event) {
        JSONObject jsonObject = event.getResponse();
        try {
            boolean success = jsonObject.getBoolean("success");
            Pref.savePreference(this, Pref.KEY_LOGIN_SUCCESS, success);
            Toast.makeText(this,"Login Successful!",Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            Log.e("JSON_PARSE_ERR", e.toString());
        }
    }


    private boolean isValidCredentials() {
        return
                txtEmail != null
                        && !txtEmail.getText().toString().isEmpty()
                        && txtPassword != null
                        && !txtPassword.getText().toString().isEmpty();
    }
}
