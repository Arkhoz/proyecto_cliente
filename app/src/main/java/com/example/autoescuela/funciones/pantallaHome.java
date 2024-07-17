package com.example.autoescuela.funciones;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tablageneral.setOrientation(LinearLayout.HORIZONTAL);
        tablageneral.setLayoutParams(params);

        LinearLayout tablageneral2=new LinearLayout(this);
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        tablageneral2.setOrientation(LinearLayout.VERTICAL);
        tablageneral2.setLayoutParams(params);

        LinearLayout cajon2=new LinearLayout(this);
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        int color = Color.parseColor("#D64545");
        ColorDrawable colorDrawable = new ColorDrawable(color);
        cajon2.setBackground(colorDrawable);
        cajon2.setLayoutParams(params);

        Button botoneliminar=new Button(this);
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        botoneliminar.setBackground(colorDrawable);
        Drawable drawable = getResources().getDrawable(android.R.drawable.ic_menu_delete);
        botoneliminar.setForeground(drawable);
        botoneliminar.setForegroundGravity(Gravity.CENTER);
        botoneliminar.setForegroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        botoneliminar.setLayoutParams(params);

        LinearLayout tablacajon1=new LinearLayout(this);
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        tablageneral.setOrientation(LinearLayout.HORIZONTAL);
        tablageneral.setLayoutParams(params);

        LinearLayout tablacajon2=new LinearLayout(this);
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        tablageneral.setOrientation(LinearLayout.HORIZONTAL);
        tablageneral.setLayoutParams(params);

        TextView profesor=new TextView(this);
        profesor.setText("");
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        profesor.setTextSize(20);
        profesor.setTypeface(Typeface.MONOSPACE);
        profesor.setGravity(Gravity.CENTER);
        profesor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        profesor.setTextColor(Color.BLACK);
        profesor.setTypeface(null,Typeface.BOLD);
        profesor.setLayoutParams(params);

        TextView clase=new TextView(this);
        clase.setText("");
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        profesor.setTextSize(20);
        profesor.setTypeface(Typeface.MONOSPACE);
        profesor.setGravity(Gravity.CENTER);
        profesor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        profesor.setTextColor(Color.BLACK);
        profesor.setTypeface(null,Typeface.BOLD);
        profesor.setLayoutParams(params);

        TextView horaclase=new TextView(this);
        horaclase.setText("");
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        profesor.setTextSize(20);
        profesor.setTypeface(Typeface.MONOSPACE);
        profesor.setGravity(Gravity.CENTER);
        profesor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        profesor.setTextColor(Color.BLACK);
        profesor.setTypeface(null,Typeface.BOLD);
        profesor.setLayoutParams(params);


        TextView diaclase=new TextView(this);
        diaclase.setText("");
        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        profesor.setTextSize(20);
        profesor.setTypeface(Typeface.MONOSPACE);
        profesor.setGravity(Gravity.CENTER);
        profesor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        profesor.setTextColor(Color.BLACK);
        profesor.setTypeface(null,Typeface.BOLD);
        profesor.setLayoutParams(params);

        tablacajon2.addView(horaclase);
        tablacajon2.addView(diaclase);
        tablacajon1.addView(clase);
        tablacajon1.addView(profesor);
        tablageneral2.addView(tablacajon1);
        tablageneral2.addView(tablacajon2);
        cajon2.addView(botoneliminar);
        tablageneral.addView(cajon2);
        tablageneral.addView(tablageneral2);
        cardView.addView(tablageneral);
        lllistaclases.addView(cardView);

    }
    public int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }


}