package com.example.crudbanco;

public class DatosPaciente {

    int id;
    String rut;
    String nombre;
    String email;
    String telefono;
    String genero;
    String sangre;

    public DatosPaciente(){

    }

    public DatosPaciente(String rut, String nombre, String email, String telefono, String genero, String sangre) {
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.genero = genero;
        this.sangre = sangre;
    }

    public DatosPaciente(int id, String rut, String nombre, String email, String telefono, String genero, String sangre) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.genero = genero;
        this.sangre = sangre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }
}
