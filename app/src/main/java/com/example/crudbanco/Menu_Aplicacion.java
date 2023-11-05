package com.example.crudbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_Aplicacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_aplicacion);
    }

    public void verEstablecimientos(View view){
        Intent cliniHospi = new Intent(this, Hospitales_y_Clinicas.class);
        startActivity(cliniHospi);
    }

    public void Encuesta(View view){
        Intent encuesta = new Intent(this,Encuesta_Paciente.class);
        startActivity(encuesta);
    }
}