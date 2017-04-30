package com.example.yohel.uno;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Tab2Conexion extends Fragment {

    private Button button;
    private EditText editText;
    private EditText editText2;
    private Context context = getActivity();

    private static final int SERVERPORT = 80;
    private static final String ADDRESS = "192.168.4.1";

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.tab1, container, false);

        button = ((Button) findViewById(R.id.button));
        editText = ((EditText) findViewById(R.id.editText));
        editText2 = ((EditText) findViewById(R.id.editText2));

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab2, container, false);
    }
}
