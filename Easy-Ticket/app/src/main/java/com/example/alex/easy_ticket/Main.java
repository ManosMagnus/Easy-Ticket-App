package com.example.alex.easy_ticket;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;


/**
 * The main activity of the project.
 * Date: 19/12/2014
 * Authors: Alexis Allafi, Kirtas Manos
 *
 */
public class Main extends Activity {

    private Button login;
    private Button register;
    private Button about;
    private Button contact;
 ///Test for GitHub


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Get the buttons by their IDs
        this.login = (Button) findViewById(R.id.loginButton1);
        this.register = (Button) findViewById(R.id.registrationButton1);
        this.about = (Button) findViewById(R.id.aboutButton1);
        this.contact = (Button) findViewById(R.id.contactButton1);


        //Set the loginButton listener
        this.login.setOnClickListener(new View.OnClickListener() {

            /**
             * When clicked should set the application content view to the login_page
             * @param view  the view that calls the function
             */
            @Override
            public void onClick(View view) {
                setContentView(R.layout.login_page);
                /*Intent intent = new Intent(Main.this, LoginActivity.class); //Create a new intent
                startActivity(intent); //Start the intent*/
            }
        });

        //Set the registerButton listener
        this.register.setOnClickListener(new View.OnClickListener() {

            /**
             * When clicked should set the application content view to the register_page
             * @param view  the view that calls the function
             */
            @Override
            public void onClick(View view) {
                setContentView(R.layout.register_page);
                /*Intent intent = new Intent(Main.this, RegisterActivity.class); //Create a new intent
                startActivity(intent);*/
            }
        });

        //Set the aboutButton listener
        this.about.setOnClickListener(new View.OnClickListener() {

            /**
             * When clicked should set the application content view to the about_page
             * @param view  the view that calls the function
             */
            @Override
            public void onClick(View view) {
                setContentView(R.layout.info_page);
                /*Intent intent = new Intent(Main.this, AboutActivity.class); //Create a new intent
                startActivity(intent);*/
            }
        });


        //Set the contactButton listener
        this.contact.setOnClickListener(new View.OnClickListener() {
            /**
             * When clicked should set the application content view to the contact_page
             * @param view  the view that calls the function
             */
            @Override
            public void onClick(View view) {
                setContentView(R.layout.contact_page);
               /* Intent intent = new Intent(Main.this, ContactActivity.class); //Create a new intent
                startActivity(intent);*/
            }
        });





        //new connectionTask().execute(new ApiConnector());

    }


    private class connectionTask extends AsyncTask<ApiConnector,Long,JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread

            return params[0].connection();
        }
    }

}