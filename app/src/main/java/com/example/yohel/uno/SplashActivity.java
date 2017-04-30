package com.example.yohel.uno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Agregado por Enrique
        //Después lo voy a modificar más, por mientras así está bien
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


        //Lo tuyo anterior
        //setContentView(R.layout.activity_main);
    }


    /*public void llamar(View view){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }*/


}
