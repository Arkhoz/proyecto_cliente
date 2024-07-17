package com.example.autoescuela.funciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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

        CardView cardView=new CardView(this);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpToPx(75));
        params.leftMargin = dpToPx(50);
        params.rightMargin = dpToPx(50);
        params.topMargin = dpToPx(20);
        params.bottomMargin = dpToPx(20);
        cardView.setRadius(dpToPx(20));

        cardView.setLayoutParams(params);

        LinearLayout tablageneral=new LinearLayout(this);
        params=new LinearLayout.LayoutParams()

        lllistaclases.addView(cardView);


    }
    public int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }


}