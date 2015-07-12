package com.example.alex.easy_ticket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.net.CookieStore;
import java.net.URISyntaxException;

/**
 * Created by Alex Allafi on 18/12/2014.
 */
public class LoginActivity extends Activity{

    private Button login;
    private EditText usernameText;
    private EditText passwordText;
    private TextView loginMsg;
    private HttpContext ctx;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        this.login = (Button) findViewById(R.id.login_button);
        usernameText = (EditText) findViewById(R.id.editText);
        passwordText = (EditText) findViewById(R.id.password_view);
        loginMsg = (TextView) findViewById(R.id.loading_message);
        loginMsg.setVisibility(View.INVISIBLE);


        this.login.setOnClickListener(new View.OnClickListener() {

            /**
             * When clicked should set the application content view to the login_page
             * @param view  the view that calls the function
             */
            @Override
            public void onClick(View view) {
                Connection connection = new Connection();

                try {
                    ctx = connection.validation(usernameText.getText().toString(), passwordText.getText().toString());
                    Intent intent = new Intent(LoginActivity.this, ChooseService.class); //Create a new intent
                    startActivity(intent); //Start the intent
                } catch (IOException e) {
                    loginMsg.setVisibility(View.VISIBLE);
                    e.printStackTrace();
                    Log.e("log_cat", "Destroy");
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public HttpContext getCtx() {
        return  ctx;
    }




}




