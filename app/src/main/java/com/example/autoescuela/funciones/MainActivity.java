package com.example.autoescuela.funciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button acceder=findViewById(R.id.bAcceder1);
        Button registrarse=findViewById(R.id.bAcceder2);
        EditText usuario=findViewById(R.id.tUsuario);
        EditText contrasenia=findViewById(R.id.tContrasenia);

        acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient cliente = new OkHttpClient();

                String usuariolog=usuario.getText().toString().toLowerCase();
                String contrasenialog=contrasenia.getText().toString();

                RequestBody body = new FormBody.Builder()
                        .add("usuario", usuariolog)
                        .add("contrasenia", contrasenialog)
                        .build();


                Request peticion = new Request.Builder()
                        .url("http://10.0.2.2:8080/api/loging")
                        .post(body)
                        .build();

                cliente.newCall(peticion).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "ha ocurrido un error", Toast.LENGTH_SHORT).show();

                            }

                        });
                        e.printStackTrace();

                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String responseBody = null;
                                try {
                                    responseBody = response.body().string();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                if (response.isSuccessful()) {
                                    if (responseBody.equals("estudiante")) {
                                        Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso como estudiante", Toast.LENGTH_SHORT).show();
                                        Intent home = new Intent(getApplicationContext(), pantallaHome.class);
                                        startActivity(home);
                                    } else if (responseBody.equals("profesor")) {
                                        Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso como profesor", Toast.LENGTH_SHORT).show();
                                        Intent home = new Intent(getApplicationContext(), pantallaHome.class);
                                        startActivity(home);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Asegúrate de que el usuario y la contraseña son correctos", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });

            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(getApplicationContext(), Registro.class);
                startActivity(registro);
            }
        });
    }

    }