package com.example.alex.easy_ticket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manos on 11/7/2015.
 */
public class ChooseService extends Activity {

    private static final String USER_AGENT = "Magic Agent" ;

    private HttpContext ctx;
    private Spinner spinner;
    private Button okButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_service_page);

      //  Log.e("log_cat", Connection.getCtx().toString());
        spinner = (Spinner) findViewById(R.id.service_spinner);

        okButton = (Button) findViewById((R.id.choose_service_button));
        ArrayAdapter<String> adapter;
        List<String> list;

        this.okButton.setOnClickListener(new View.OnClickListener() {

            /**
             * When clicked should set the application content view to the login_page
             * @param view  the view that calls the function
             */
            @Override
            public void onClick(View view) {
                try {
                    connection(serviceChoosen(spinner.getSelectedItem().toString()));
                    Intent intent = new Intent(ChooseService.this,ExistingTicketActicity.class); //Create a new intent
                    startActivity(intent); //Start the intent
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });


        list = new ArrayList<String>();
        list.add("Piraeus Bank");
        list.add("Eurobank");
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    String serviceChoosen(String option){
        if(option.equals("Piraeus Bank")){
            Log.e("Log_cat",option);
            return  "Piraeus+Bank";
        }
        Log.e("Log_cat",option);
        return "Eurobank";
    }

    public void setCtx(HttpContext ctxN){
        ctx = ctxN;
    }

    private void connection(String service) throws IOException, URISyntaxException {
        URI url = new URI("http://www.easy-ticket.gr/validate_choose_service.php");


        StringBuffer buffer = new StringBuffer();

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);


        List<NameValuePair> nvList = new ArrayList<NameValuePair>();
        BasicNameValuePair usvp = new BasicNameValuePair("service", service);


        nvList.add(usvp);



        post.setHeader("User-Agent", "DOOM");

        post.setEntity(new UrlEncodedFormEntity(nvList));


        HttpResponse resp = client.execute(post);

        System.out.println(resp.toString());

        InputStream is  = resp.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder str = new StringBuilder();
        String line = null;
        while((line = reader.readLine()) != null){
            str.append(line + "\n");
        }
        is.close();
        buffer.append(str.toString());


        System.out.println(buffer);


        CookieStore store = ((DefaultHttpClient) client).getCookieStore();

        List<Cookie> cookies = store.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {

                System.out.println(c.getName() + " |||| " + c.getValue());
                store.addCookie(c);
            }
        }

    }





}
