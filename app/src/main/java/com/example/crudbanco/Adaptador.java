package com.example.crudbanco;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter{
    ArrayList<DatosPaciente> listaContacto;
    daoDatosPacientes dao;
    DatosPaciente c;
    Activity a;
    int id = 0;
    public Adaptador(Activity a, ArrayList<DatosPaciente> lista, daoDatosPacientes dao ){
        this.listaContacto = lista;
        this.a= a;
        this.dao= dao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getCount() {
        return listaContacto.size();
    }
    @Override
    public Object getItem(int i) {
        c = listaContacto.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        c = listaContacto.get(i);
        return c.getId();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {

        View v = view;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item, null);
        }

        c = listaContacto.get(posicion);
        TextView rut=v.findViewById(R.id.rut);
        TextView nombre=v.findViewById(R.id.nombre);
        TextView email=v.findViewById(R.id.email);
        TextView telefono=v.findViewById(R.id.telefono);
        TextView genero=v.findViewById(R.id.genero);
        TextView sangre=v.findViewById(R.id.sangre);
        Button editar= v.findViewById(R.id.btn_editar);
        Button eliminar= v.findViewById(R.id.btn_eliminar);
        rut.setText(c.getRut());
        nombre.setText(c.getNombre());
        email.setText(c.getEmail());
        telefono.setText(c.getTelefono());
        genero.setText(c.getGenero());
        sangre.setText(c.getSangre());
        editar.setTag(posicion);
        eliminar.setTag(posicion);


        editar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int pos = Integer.parseInt(view.getTag().toString());
                final Dialog dialog = new Dialog(a);
                dialog.setTitle("Editar Registro");
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
                Button cancelar = dialog.findViewById(R.id.btn_cancelar);
                c = listaContacto.get(pos);
                setId(c.getId());
                rut.setText(c.getRut());
                nombre.setText(c.getNombre());
                email.setText(c.getEmail());
                telefono.setText(c.getTelefono());
                genero.setText(c.getGenero());
                sangre.setText(c.getSangre());


                guardar.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        try {
                            c = new DatosPaciente(getId(), rut.getText().toString(),
                                    nombre.getText().toString(),
                                    email.getText().toString(),
                                    telefono.getText().toString(),
                                    genero.getText().toString(),
                                    sangre.getText().toString());
                            dao.editar(c);
                            listaContacto = dao.verTodo();
                            notifyDataSetChanged();
                            dialog.dismiss();
                        }catch (Exception e){
                            Toast.makeText(a, "Error", Toast.LENGTH_SHORT).show();
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

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=Integer.parseInt(view.getTag().toString());
                c = listaContacto.get(posicion);
                setId(c.getId());
                AlertDialog.Builder del = new AlertDialog.Builder(a);
                del.setMessage("¿Estas seguro de eliminar los datos?");
                del.setCancelable(false);
                del.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dao.eliminar(getId());
                        listaContacto = dao.verTodo();
                        notifyDataSetChanged();
                    }
                });
                del.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                del.show();
            }
        });
        return v;
    }
}


