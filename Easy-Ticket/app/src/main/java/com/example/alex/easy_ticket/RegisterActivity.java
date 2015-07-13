package com.example.alex.easy_ticket;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Theodosis Melidis on 12/7/2015.
 */
public class RegisterActivity extends Activity {

    private Button register;
    private EditText first_name;
    private EditText last_name;
    private EditText email;
    private EditText conf_email;
    private EditText user_name;
    private EditText pass;
    private EditText conf_pass;
    private TextView registerMsg;
    private TextView notValidEmailMsg;
    private TextView notEqualPasswordsMsg;
    private TextView notEqualEmailsMsg;

    /**
     * Checks if texts of password and confirmPassword are equal
     *
     * @param password EditText with password text
     * @param confirmPassword EditText with confirmPassword text
     * @return true equality holds, false equality does not hold
     */
    private Boolean checkPasswords(EditText password, EditText confirmPassword){
        return(password.getText().toString() == confirmPassword.getText().toString());
    }

    /**
     * Checks if texts of email and confirmEmail are equal
     *
     * @param email EditText with email text
     * @param confirmEmail EditText with confirmEmail text
     * @return true equality holds, false equality does not hold
     */
    private Boolean checkEmails(EditText email, EditText confirmEmail){
        return(email.getText().toString() == conf_email.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
/*
        registerMsg=(TextView) findViewById(R.id.mean_waiting_time);
        notValidEmailMsg=(TextView) findViewById(R.id.mean_waiting_time);
        notEqualPasswordsMsg=(TextView) findViewById(R.id.mean_waiting_time);
        notEqualEmailsMsg=(TextView) findViewById(R.id.mean_waiting_time);
        this.register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (!checkPasswords(pass, conf_pass))
                    notEqualPasswordsMsg.setVisibility(View.VISIBLE);

                if (checkEmails(email, conf_email)) {
                    EmailValidator emailValidator = new EmailValidator();
                    if (!emailValidator.validate(email.getText().toString()))
                        notValidEmailMsg.setVisibility(View.VISIBLE);
                } else
                    notEqualEmailsMsg.setVisibility(View.VISIBLE);
            }
        });
*/

    }



    private class EmailValidator {

        private Pattern pattern;
        private Matcher matcher;

        private static final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        public void EmailValidator(){}

        public EmailValidator() {
            pattern = Pattern.compile(EMAIL_PATTERN);
        }

        /**
         * Validate email with regular expression
         *
         * @param emailToValidate email for validation
         * @return true valid email, false invalid email
         */
        private boolean validate(final String emailToValidate) {

            matcher = pattern.matcher(emailToValidate);
            return matcher.matches();

        }
    }
}
