package com.example.crudbanco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class daoDatosPacientes {
    SQLiteDatabase bd;
    ArrayList<DatosPaciente>lista = new ArrayList<DatosPaciente>();
    DatosPaciente c;
    Context ct;
    String nombreBD= "BDContactos";
    String tabla = "create table if not exists contacto(id integer primary key autoincrement, rut text, nombre text, email text, telefono text, genero text, sangre text)";


    public daoDatosPacientes(Context c){
        this.ct=c;
        bd=c.openOrCreateDatabase(nombreBD, Context.MODE_PRIVATE, null);
        bd.execSQL(tabla);
    }

    public boolean insertar(DatosPaciente c){

        ContentValues contenedor = new ContentValues();
        contenedor.put("rut", c.getRut());
        contenedor.put("nombre", c.getNombre());
        contenedor.put("email", c.getEmail());
        contenedor.put("telefono", c.getTelefono());
        contenedor.put("genero", c.getGenero());
        contenedor.put("sangre", c.getSangre());
        return (bd.insert("contacto", null, contenedor))>0;
    }

    public boolean eliminar(int id){
        return (bd.delete("contacto","id="+id,null ))>0;
    }

    public boolean editar(DatosPaciente c){

        ContentValues contenedor = new ContentValues();
        contenedor.put("rut", c.getRut());
        contenedor.put("nombre", c.getNombre());
        contenedor.put("email", c.getEmail());
        contenedor.put("telefono", c.getTelefono());
        contenedor.put("genero", c.getGenero());
        contenedor.put("sangre", c.getSangre());
        return (bd.update("contacto", contenedor, "id="+c.getId(),null))>0;
    }

    public ArrayList<DatosPaciente>verTodo(){

        lista.clear();
        Cursor cursor = bd.rawQuery("select * from contacto", null);

        if (cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                lista.add(new DatosPaciente(cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6)));
            }while (cursor.moveToNext());
        }
        return lista;
    }

    public DatosPaciente verUno(int posicion){
        Cursor cursor = bd.rawQuery("select * from contacto", null);
        cursor.moveToPosition(posicion);
        c=new DatosPaciente(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6));
        return c;
    }
}
