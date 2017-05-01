package com.example.yohel.uno;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Main4Activity extends AppCompatActivity  {

    private EditText entrada;
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab2);
        entrada = (EditText) findViewById(R.id.EditText01);
        salida = (TextView) findViewById(R.id.TextView01);


        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.
                Builder().permitNetwork().build());
    }




    public void Buscar(View view){
        try {
            String palabras = entrada.getText().toString();
            String resultado = resultadosGoogle(palabras);
            salida.append(palabras + "--" + resultado + "\n");
        } catch (Exception e) {
            salida.append("Error al conectar\n");
            Log.e("HTTP", e.getMessage(), e);
        }
    }




    String resultadosGoogle(String palabras) throws Exception {
        String pagina = "", devuelve = "";
        // URL url = new URL("http://www.google.es/search?hl=es&q=\""
        URL url = new URL("http://192.168.4.1:80/search?hl=es&q=\""
                + URLEncoder.encode(palabras, "UTF-8") + "\"");
        HttpURLConnection conexion = (HttpURLConnection)
                url.openConnection();
        conexion.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1)");
        if (conexion.getResponseCode()==HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conexion.getInputStream()));
            String linea = reader.readLine();
            while (linea != null) {
                pagina += linea;
                linea = reader.readLine();
            }
            reader.close();
            devuelve = buscaAproximadamente(pagina);
        } else {
            devuelve = "ERROR: " + conexion.getResponseMessage();
        }
        conexion.disconnect();
        return devuelve;


    }
    String buscaAproximadamente(String pagina){
        int ini = pagina.indexOf("Aproximadamente");
        if (ini != -1) {
            int fin = pagina.indexOf(" ", ini + 16);
            return pagina.substring(ini + 16, fin);
        } else {
            return "no encontrado";
        }
    }



}


/*
Codigo Correcto

public class MainActivity extends Activity {
   private EditText entrada;
   private TextView salida;
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      entrada = (EditText) findViewById(R.id.EditText01);
      salida = (TextView) findViewById(R.id.TextView01);
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.
            Builder().permitNetwork().build());
   }
   public void buscar(View view){
      try {
         String palabras = entrada.getText().toString();
         String resultado = resultadosGoogle(palabras);
         salida.append(palabras + "--" + resultado + "\n");
      } catch (Exception e) {
         salida.append("Error al conectar\n");
         Log.e("HTTP", e.getMessage(), e);
      }
   }

   String resultadosGoogle(String palabras) throws Exception {
      String pagina = "", devuelve = "";
      URL url = new URL("http://www.google.es/search?hl=es&q=\""
            + URLEncoder.encode(palabras, "UTF-8") + "\"");
      HttpURLConnection conexion = (HttpURLConnection)
            url.openConnection();
      conexion.setRequestProperty("User-Agent",
            "Mozilla/5.0 (Windows NT 6.1)");
      if (conexion.getResponseCode()==HttpURLConnection.HTTP_OK) {
         BufferedReader reader = new BufferedReader(new
            InputStreamReader(conexion.getInputStream()));
         String linea = reader.readLine();
         while (linea != null) {
            pagina += linea;
            linea = reader.readLine();
         }
         reader.close();
         devuelve = buscaAproximadamente(pagina);
      } else {
         devuelve = "ERROR: " + conexion.getResponseMessage();
      }
      conexion.disconnect();
      return devuelve;
   }
   String buscaAproximadamente(String pagina){
      int ini = pagina.indexOf("Aproximadamente");
      if (ini != -1) {
         int fin = pagina.indexOf(" ", ini + 16);
         return pagina.substring(ini + 16, fin);
      } else {
         return "no encontrado";
      }
   }
}


 */



