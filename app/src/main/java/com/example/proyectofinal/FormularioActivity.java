package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormularioActivity extends AppCompatActivity {
    EditText nombre, direccion, telefono, correo;
    CheckBox local, delivery, gallina, chancho, aji, pavita, chicha, gaseosa, pisco, vino;
    Spinner postres;
    Button enviar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nombre = (EditText) findViewById(R.id.nombre);
        direccion=(EditText) findViewById(R.id.direccion);
        telefono=(EditText) findViewById(R.id.telefono);
        correo=(EditText) findViewById(R.id.correo);

        local =(CheckBox) findViewById(R.id.local);
        delivery=(CheckBox) findViewById(R.id.delivery);
        gallina=(CheckBox) findViewById(R.id.gallina);
        chancho=(CheckBox) findViewById(R.id.chancho);
        aji=(CheckBox) findViewById(R.id.aji);
        pavita =(CheckBox) findViewById(R.id.pavita);
        chicha =(CheckBox) findViewById(R.id.chicha);
        gaseosa =(CheckBox) findViewById(R.id.gaseosa);
        pisco =(CheckBox) findViewById(R.id.pisco);
        vino = (CheckBox) findViewById(R.id.vino);

        postres =(Spinner) findViewById(R.id.postres);

        // Inicialización de los botones
        cancelar = findViewById(R.id.cancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularioActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });





        enviar = findViewById(R.id.enviar);

        // Acción del botón "enviar"
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nombre.getText().toString().equals("")|| direccion.getText().toString().equals("")
                        || telefono.getText().toString().equals("") || correo.getText().toString().equals("")
                        || (!local.isChecked() && !delivery.isChecked())){


                    Toast.makeText(FormularioActivity.this, "Por favor Ingrese sus datos",Toast.LENGTH_LONG).show();
                }else{
                    String selectedItem = postres.getSelectedItem().toString();


                Intent intent = new Intent(FormularioActivity.this, PlatillosActivity.class);
                    intent.putExtra("nombre", nombre.getText().toString());
                    intent.putExtra("direccion", direccion.getText().toString());
                    intent.putExtra("telefono", telefono.getText().toString());
                    intent.putExtra("correo", correo.getText().toString());
                    intent.putExtra("local", local.isChecked());
                    intent.putExtra("delivery", delivery.isChecked());
                    intent.putExtra("gallina", gallina.isChecked());
                    intent.putExtra("chancho", chancho.isChecked());
                    intent.putExtra("aji", aji.isChecked());
                    intent.putExtra("pavita", pavita.isChecked());
                    intent.putExtra("chicha", chicha.isChecked());
                    intent.putExtra("gaseosa", gaseosa.isChecked());
                    intent.putExtra("pisco", pisco.isChecked());
                    intent.putExtra("vino", vino.isChecked());
                    intent.putExtra("postres", selectedItem);
                    startActivity(intent);
                }
            }
        });

        // Configuración de la ActionBar para mostrar el botón de retroceso
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Manejo de los Insets de la ventana para ajustar la vista según las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Termina la actividad cuando se presiona el botón de retroceso
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
