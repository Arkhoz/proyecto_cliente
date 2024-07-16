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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
        EditText tusuario=findViewById(R.id.tUsuarioReg);
        EditText tpassword=findViewById(R.id.tPassReg);
        EditText tnombre=findViewById(R.id.tNombreReg);
        EditText tcorreo=findViewById(R.id.tCorreoReg);
        EditText ttelefono=findViewById(R.id.tTelefonoReg);
        EditText tdni=findViewById(R.id.tDniReg);

        ImageButton ibregistrarse=findViewById(R.id.ibRegistro);





        ibregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario;
                String password;
                String nombre;
                String correo;
                String telefono;
                String dni;

                OkHttpClient cliente = new OkHttpClient();
                Gson gson = new Gson();

                RequestBody body1 = RequestBody.create(gson.toJson(estudiante),
                        MediaType.get("application/json; charset=utf-8"));

                Request peticion = new Request.Builder()
                        .url("jdbc:mysql://localhost:3306/ServerAutoEscuela2")
                        .get()
                        .build();
            }
        });


    }
}