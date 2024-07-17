package com.example.autoescuela.funciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.autoescuela.R;
import com.example.autoescuela.funciones.HacerCita;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class pantallaHome extends AppCompatActivity {

    LinearLayout lllistaclases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FloatingActionButton agregar=findViewById(R.id.bAgregar);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cita=new Intent(getApplicationContext(), HacerCita.class);
                startActivity(cita);
            }
        });
    }


    public void generarcards(){
        lllistaclases=findViewById(R.id.lllistaclases);

        L


    }


}