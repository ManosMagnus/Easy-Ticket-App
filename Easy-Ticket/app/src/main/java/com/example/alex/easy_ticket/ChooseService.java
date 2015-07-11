package com.example.alex.easy_ticket;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.apache.http.protocol.HttpContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manos on 11/7/2015.
 */
public class ChooseService extends Activity {

    private HttpContext ctx;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_service_page);

        spinner = (Spinner) findViewById(R.id.service_spinner);
        ArrayAdapter<String> adapter;
        List<String> list;

        list = new ArrayList<String>();
        list.add("Pereus Bank");
        list.add("Eurobank");
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public void setCtx(HttpContext ctxN){
        ctx = ctxN;
    }
}
