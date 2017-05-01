package com.example.yohel.uno;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private TableLayout tabla;


    private FragmentTabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //Agregado por Enrique
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabla = (TabLayout) findViewById(R.id.tabs);
        tabla.setupWithViewPager(mViewPager);



        /*tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,
                getSupportFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Principal"),
                Tab1Principal.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Conexion"),
                Tab2Conexion.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Acerca de..."),
                Tab3AcercaDe.class, null);*/



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





    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Tab1Principal tab1 = new Tab1Principal();
                    return tab1;
                case 1:
                    Tab2Conexion tab2 = new Tab2Conexion();
                    return tab2;
                case 2:
                    Tab3AcercaDe tab3 = new Tab3AcercaDe();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Muestra un total de 3 páginas
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Principal";
                case 1:
                    return "Conexion";
                case 2:
                    return "Acerca de";
            }
            return null;
        }
    }

}
