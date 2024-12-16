package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CompletarActivity extends AppCompatActivity {
    Button registrarme;
    EditText nombre1, apellidos, celular, correo1, clave;
    RadioButton masculino, femenino;
    Spinner nacionalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_completar);

        nombre1 =(EditText) findViewById(R.id.nombre1);
        apellidos =(EditText) findViewById(R.id.apellidos);
        celular =(EditText) findViewById(R.id.celular);
        correo1 =(EditText) findViewById(R.id.correo1);
        clave =(EditText) findViewById(R.id.clave);

        masculino =(RadioButton) findViewById(R.id.masculino);
        femenino =(RadioButton) findViewById(R.id.femenino);

        nacionalidad =(Spinner) findViewById(R.id.nacionalidad);

        registrarme =(Button) findViewById(R.id.registrarme);
        registrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre1.getText().toString().equals("") || apellidos.getText().toString().equals("")
                        || celular.getText().toString().equals("") || correo1.getText().toString().equals("")
                        || clave.getText().toString().equals("")
                        || (!masculino.isChecked() && !femenino.isChecked())) {


                    Toast.makeText(CompletarActivity.this, "Por favor Ingrese sus datos", Toast.LENGTH_LONG).show();
                } else {
                    String selectedItem = nacionalidad.getSelectedItem().toString();

                    Intent intent = new Intent(CompletarActivity.this, ClientesActivity.class);
                    intent.putExtra("nombre1", nombre1.getText().toString());
                    intent.putExtra("apellidos", apellidos.getText().toString());
                    intent.putExtra("celular", celular.getText().toString());
                    intent.putExtra("correo1", correo1.getText().toString());
                    intent.putExtra("masculino", masculino.isChecked());
                    intent.putExtra("femenino", femenino.isChecked());
                    intent.putExtra("nacionalidad", selectedItem);
                    startActivity(intent);
                }
            }

        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}