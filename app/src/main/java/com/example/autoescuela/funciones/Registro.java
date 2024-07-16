package com.example.autoescuela.funciones;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.autoescuela.R;
import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText usuario=findViewById(R.id.tUsuarioReg);
        EditText contrasenia=findViewById(R.id.tPassReg);
        EditText nombre=findViewById(R.id.tNombreReg);
        EditText correo=findViewById(R.id.tCorreoReg);
        EditText telefono=findViewById(R.id.tTelefonoReg);
        EditText dni=findViewById(R.id.tDniReg);

        ImageButton ibregistrarse=findViewById(R.id.ibRegistro);

        ibregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient cliente = new OkHttpClient();
                Gson gson = new Gson();

                RequestBody body = new FormBody.Builder().add(usuario.getText()+"",
                        contrasenia.getText()+"",
                        nombre.getText()+"",
                        correo.getText()+"",
                        telefono.getText()+"",
                        dni.getText()+"").build();




            }
        });


    }
}