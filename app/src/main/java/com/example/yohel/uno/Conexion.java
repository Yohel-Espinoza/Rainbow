package com.example.yohel.uno;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yohel on 01/05/2017.
 */

public class Conexion extends AppCompatActivity {


    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab2);

        salida = (TextView) findViewById(R.id.TextView01);


        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.
                Builder().permitNetwork().build());
    }
    public void Conexion(View view){
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
            salida.append("Proceso Terminado\n");
            Log.e("HTTP", e.getMessage(), e);
        }
    }


}
