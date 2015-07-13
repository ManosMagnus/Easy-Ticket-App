package com.example.alex.easy_ticket;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import  android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Theodosis Melidis on 12/7/2015.
 */
public class RegisterActivity extends Activity
    {
        String first_name;
        String last_name;
        String email;
        String conf_email;
        String user_name;
        String pass;
        String conf_pass;




    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.register_page);
        final EditText firstNameField = (EditText) findViewById(R.id.name_view);
        first_name= firstNameField.getText().toString();

        final EditText lastNameField = (EditText) findViewById(R.id.surname_view);
        last_name= lastNameField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.email_view);
        email= emailField.getText().toString();

        final EditText conf_emailField = (EditText) findViewById(R.id.email_ver_view);
        conf_email= conf_emailField.getText().toString();

        final EditText user_nameField = (EditText) findViewById(R.id.editText);
        user_name= user_nameField.getText().toString();

        final EditText passField = (EditText) findViewById(R.id.password_view);
        pass= passField.getText().toString();

        final EditText pass_confField = (EditText) findViewById(R.id.password_ver_view);
        conf_pass= passField.getText().toString();
        View v = findViewById(R.id.register_button);





    }

        public void sendFeedback(View v)
    {
        setContentView(R.layout.activity_main);
    }
}
