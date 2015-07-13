package com.example.alex.easy_ticket;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by manos on 13/7/2015.
 */
public class ExistingTicketActicity  extends Activity {

    private Button button;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.existing_ticket_page);

        this.button = (Button) findViewById(R.id.button);
        msg = (TextView) findViewById(R.id.mean_waiting_time);
        msg.setVisibility(View.INVISIBLE);

        this.button.setOnClickListener(new View.OnClickListener() {

            /**
             * When clicked should set the application content view to the login_page
             * @param view  the view that calls the function
             */
            @Override
            public void onClick(View view) {
                    button.setVisibility(View.INVISIBLE);
                    msg.setVisibility(View.VISIBLE);

            }
        });
    }


    }
