package com.example.yohel.uno;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Yohel on 28/04/2017.
 */

public class Tab2 extends FragmentActivity {

    private Button button;
    private EditText editText;
    private EditText editText2;
    private Context context = this;

    private static final int SERVERPORT = 80;
    private static final String ADDRESS = "192.168.4.1";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab2);

        button = ((Button) findViewById(R.id.button));
        editText = ((EditText) findViewById(R.id.editText));
        editText2 = ((EditText) findViewById(R.id.editText2));






    }





}
