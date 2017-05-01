package com.example.yohel.uno;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;


import android.support.v4.app.FragmentTabHost;


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
