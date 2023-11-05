package com.example.crudbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class Encuesta_Paciente extends AppCompatActivity {
    daoDatosPacientes dao;
    Adaptador adaptador;
    ArrayList<DatosPaciente>listacontact;
    DatosPaciente c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_paciente);

        dao= new daoDatosPacientes(Encuesta_Paciente.this);
        listacontact = dao.verTodo();
        adaptador=new Adaptador(this, listacontact, dao);
        ListView list= findViewById(R.id.lista);
        Button insertar = findViewById(R.id.btn_insertar);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        insertar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(Encuesta_Paciente.this);
                dialog.setTitle("Nuevo Registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogo);
                dialog.show();
                final EditText rut = dialog.findViewById(R.id.et_rut);
                final EditText nombre = dialog.findViewById(R.id.et_nombre);
                final EditText email = dialog.findViewById(R.id.et_email);
                final EditText telefono = dialog.findViewById(R.id.et_telefono);
                final EditText genero = dialog.findViewById(R.id.et_genero);
                final EditText sangre = dialog.findViewById(R.id.et_sangre);
                Button guardar = dialog.findViewById(R.id.btn_agregar);
                guardar.setText("Agregar");
                Button cancelar = dialog.findViewById(R.id.btn_cancelar);

                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            c = new DatosPaciente(rut.getText().toString(),
                                    nombre.getText().toString(),
                                    email.getText().toString(),
                                    telefono.getText().toString(),
                                    genero.getText().toString(),
                                    sangre.getText().toString());
                            dao.insertar(c);
                            listacontact = dao.verTodo();
                            adaptador.notifyDataSetChanged();
                            dialog.dismiss();
                        }catch (Exception e){
                            Toast.makeText(getApplication(), "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

    }
}