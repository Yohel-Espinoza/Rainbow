package com.example.yohel.uno;

import android.support.design.widget.TabLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;


public class Main2Activity extends FragmentActivity  {
//public class Main2Activity extends AppCompatActivity {


    private TableLayout tabla;
    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



       // TabLayout tabla = (TabLayout) findViewById(R.id.tabs);
        //tabla.addTab(tabla.newTab().setText("Principal"));
        //tabla.addTab(tabla.newTab().setText("Mas"));
        //tabla.addTab(tabla.newTab().setText("Acerca de..."));


        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,
                getSupportFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Principal"),
                Tab1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Conexion"),
                Tab2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Acerca de..."),
                Tab3.class, null);




      }















}
