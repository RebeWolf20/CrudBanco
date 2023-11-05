package com.example.crudbanco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Hospitales_y_Clinicas extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener,GoogleMap.OnMapLongClickListener {

    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitales_yclinicas);

        txtLatitud = findViewById(R.id.et_lat);
        txtLongitud = findViewById(R.id.et_long);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap){
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        hospital("Hospital Dr. Hernán Henríquez Aravena", -38.7367466, -72.6008755);
        hospital("Clinica ICOSS", -38.734754, -72.627242);
        hospital("Clinica RED SALUD", -38.736576, -72.6314284);
        hospital("Clinica Alemana", -38.736576, -72.6314284);
        hospital("Hospital Complejo Asistencial Padre Las Casas", -38.7678304, -72.6182665);
        hospital("Centro Médico Los Pablos Alemana", -38.7451383, -72.6441628);
        hospital("hospital chile",  -33.8659904, -70.7469697);
        hospital("Hospital Clínico Regional de Concepción Dr. Guillermo Grant Benavente", -37.3416949, -72.9211757);
        hospital("Hospital Victoria", -38.5678972,-73.0803193);
        hospital("Hospital Dr. Dino Stagno Maccioni", -38.5678972,-73.0803193);
        hospital("Hospital de Galvarino", -38.5678972,-73.0803193);
        hospital("Hospital Dr. Abraham Godoy Peña (Antiguo)", -38.5678972,-73.0803193);
        hospital("Hospital Dr. Oscar Hernandez Escobar", -38.5678972, -73.0803193);
        hospital("Hospital de Vilcún", -38.5678972, -73.0803193);
        hospital("Servicio Salud Araucania/Hospital Nueva Imperial", -38.7488688, -72.6526356);
        hospital("Servicio Salud Araucania Sur/Hospital Pi Trufquen",-38.7488688, -72.6526356);
        hospital("Hospital Makewe", -38.7174843, -73.2491331);
        hospital("Hospital de Carahue", -38.7548611, -73.0459426);
        hospital("Nuevo Hospital de Pitrufquen", -39.3068905, -72.6467945);


    }
    private void hospital(String title, double latitude, double longitude) {
        LatLng ubihospital = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(ubihospital).title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubihospital));
    }
    @Override
    public void onMapClick(@NonNull LatLng latLng){
        txtLatitud.setText("" + latLng.latitude);
        txtLongitud.setText("" + latLng.longitude);
    }
    @Override
    public void onMapLongClick(@NonNull LatLng latLng){
        txtLatitud.setText("" + latLng.latitude);
        txtLongitud.setText("" + latLng.longitude);
    }
    public void Menu(View view){
        Intent menu= new Intent(this, Menu_Aplicacion.class);
        startActivity(menu);

    }
}