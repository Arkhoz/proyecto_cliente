package com.example.autoescuela.funciones;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.autoescuela.R;

import java.util.ArrayList;
import java.util.List;

public class HacerCita extends AppCompatActivity {

    Spinner spinnerNompro;
    Spinner spinnerHora;
    Spinner spinnerDia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hacer_cita);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinnerNompro = findViewById(R.id.spinprofesores);
        spinnerHora = findViewById(R.id.spinhora);
        spinnerDia = findViewById(R.id.spinfecha);

        //Definir las listas

        List<String> profesores = new ArrayList<>();
        profesores.add("Ellioth");
        profesores.add("Luis");
        profesores.add("Virginia");
        profesores.add("Victor Marcos");
        profesores.add("Victor");

        List<String> horas = new ArrayList();
        horas.add("9:00");
        horas.add("10:00");
        horas.add("11:00");
        horas.add("12:00");
        horas.add("13:00");

        List<String> dias = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            dias.add(String.valueOf(i));
        }

        // Inicializar los Spinners
        inicializarSpinner(spinnerNompro, profesores);
        inicializarSpinner(spinnerHora, horas);
        inicializarSpinner(spinnerDia, dias);
    }

    private void inicializarSpinner(Spinner spinner, List<String> items) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Se maneja la selección aquí
                String seleccionado = items.get(position);
                Toast.makeText(HacerCita.this, "Seleccionado: " + seleccionado, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}