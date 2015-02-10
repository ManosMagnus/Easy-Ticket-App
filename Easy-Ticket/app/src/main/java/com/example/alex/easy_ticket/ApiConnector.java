package com.example.alex.easy_ticket;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

/**
* Author: Kirtas Manos
* Date: 18/12/2014.
*/
public class ApiConnector {


    public JSONArray connection()
    {
        // URL for getting all customers


        String url = "http://nsgeorgi.webpages.auth.gr/dw";

        Log.e("log_cat","running");

        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        Log.e("log_cat","1st check");
        try
        {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            Log.e("log_cat","2.1nd check");
            HttpGet httpGet = new HttpGet(url);
            Log.e("log_cat","2.2nd check");

            HttpResponse httpResponse = httpClient.execute(httpGet);
            Log.e("log_cat","2.3nd check");

            httpEntity = httpResponse.getEntity();

            Log.e("log_cat","2.4nd check");


        } catch (ClientProtocolException e) {

            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here


        } catch (IOException e) {
            e.printStackTrace();
        }


        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;

//        Log.e("log_cat","Edw: " + jsonArray.toString());

        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                Log.e("Entity Response  : ", entityResponse);

                jsonArray = new JSONArray(entityResponse);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Log.e("log_cat","Edw: " + jsonArray.toString());
        return jsonArray;


    }


}