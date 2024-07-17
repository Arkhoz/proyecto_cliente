package com.example.autoescuela.funciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.autoescuela.R;
import com.example.autoescuela.clases.Estudiante;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
                String usuario=tusuario.getText().toString();
                String password=tpassword.getText().toString();
                String nombre=tnombre.getText().toString();
                String correo=tcorreo.getText().toString();
                String telefono=ttelefono.getText().toString();
                String dni=tdni.getText().toString();
                Estudiante est = new Estudiante(usuario,password,nombre,correo,telefono,dni);

                OkHttpClient cliente = new OkHttpClient();
                Gson gson = new Gson();

                RequestBody body1 = RequestBody.create(gson.toJson(est),
                        MediaType.get("application/json; charset=utf-8"));

                Request peticion = new Request.Builder()
                        .url("http://10.0.2.2:8080/api/registro")
                        .post(body1)
                        .build();

                cliente.newCall(peticion).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();

                            }
                        });
                        e.printStackTrace();

                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (response.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                                    Intent home = new Intent(getApplicationContext(), pantallaHome.class);
                                    startActivity(home);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Registro fallido", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
            }
        });


    }
}