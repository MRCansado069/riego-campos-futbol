package com.example.riegoapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputCiudad;
    Spinner spinnerCesped, spinnerSuelo, spinnerUso;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputCiudad = findViewById(R.id.inputCiudad);
        spinnerCesped = findViewById(R.id.spinnerCesped);
        spinnerSuelo = findViewById(R.id.spinnerSuelo);
        spinnerUso = findViewById(R.id.spinnerUso);
        resultado = findViewById(R.id.resultado);

        Button boton = findViewById(R.id.btnCalcular);
        boton.setOnClickListener(view -> {
            String ciudad = inputCiudad.getText().toString();
            String cesped = spinnerCesped.getSelectedItem().toString();
            String suelo = spinnerSuelo.getSelectedItem().toString();
            String uso = spinnerUso.getSelectedItem().toString();
            String recomendacion = calcularRiego(ciudad, cesped, suelo, uso);
            resultado.setText(recomendacion);
        });
    }

    private String calcularRiego(String ciudad, String cesped, String suelo, String uso) {
        float insolacion = ciudad.equals("Madrid") ? 9.0f : 8.0f;
        if (cesped.equals("Bermuda híbrida") && suelo.equals("arenoso") && insolacion > 6 && uso.equals("intensivo")) {
            return "Aspersión sectorizada con sensores";
        } else if (cesped.equals("Festuca") && suelo.equals("arcilloso")) {
            return "Aspersión + drenaje activo";
        } else {
            return "Sistema mixto: goteo + aspersión puntual";
        }
    }
}
