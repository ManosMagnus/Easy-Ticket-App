package com.example.alex.easy_ticket;

import android.util.Log;

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
public class Connection {


    private static final String USER_AGENT = "Magic Agent" ;

    public void Connection(){
;


    }

    public HttpContext validation(String username, String password) throws IOException, URISyntaxException {
        URI url = new URI("http://www.easy-ticket.gr/validate_login_home.php");
        Log.e("log_cat",url.getHost() + url.getRawPath());

        StringBuffer buffer = new StringBuffer();

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);


        List<NameValuePair> nvList = new ArrayList<NameValuePair>();

        BasicNameValuePair usvp = new BasicNameValuePair("username", username);
        BasicNameValuePair pasvp = new BasicNameValuePair("password", password);

        nvList.add(usvp);
        nvList.add(pasvp);
        post.setHeader("User-Agent", USER_AGENT);
        post.setEntity(new UrlEncodedFormEntity(nvList));


        HttpResponse resp = client.execute(post);





        Log.e("log_cat", "Doooooom");



        InputStream is  = resp.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder str = new StringBuilder();
        String line = null;
        while((line = reader.readLine()) != null){
            str.append(line + "\n");
        }
        is.close();
        buffer.append(str.toString());

        Log.e("log_cat", str.toString());

        CookieStore store = ((DefaultHttpClient) client).getCookieStore();

        List<Cookie> cookies = store.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {

                Log.e("log_cat",c.getName() + " |||| " + c.getValue());
                        store.addCookie(c);
            }
        }

        HttpContext ctx = new BasicHttpContext();
        ctx.setAttribute(ClientContext.COOKIE_STORE, store);

        return ctx;


    }



}
