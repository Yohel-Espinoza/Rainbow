package com.example.yohel.uno;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info: {
                Intent intent = new Intent(this, AcercaDe.class);
                startActivity(intent);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.
                Builder().permitNetwork().build());
      }

    public void ConexionM(View view){
        try {
            String pagina = "";
            // URL url = new URL("http://www.google.es/search?hl=es&q=\""



            URL url = new URL("http://192.168.4.1:80/search?hl=es&q=\"");
            HttpURLConnection conexion = (HttpURLConnection)
                    url.openConnection();
            conexion.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1)");

            if (conexion.getResponseCode()==HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new
                        InputStreamReader (conexion.getInputStream()));

                String linea = reader.readLine();
                while (linea != null) {
                    pagina += linea;
                    linea = reader.readLine();
                }
                reader.close();
            }





            conexion.disconnect();




        } catch (Exception e) {

            Log.e("HTTP", e.getMessage(), e);
        }


      //  WebView myWebView = (WebView) this.findViewById(R.id.web);
        //myWebView.loadUrl("https://192.168.4.1:80/");


    }

}
