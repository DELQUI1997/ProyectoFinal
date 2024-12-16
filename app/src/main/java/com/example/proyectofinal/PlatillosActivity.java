package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlatillosActivity extends AppCompatActivity {
    Button terminar;
    TextView textView14;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_platillos);

        textView14 = findViewById(R.id.textView14);
        nombre = findViewById(R.id.nombre);

        String direccion = getIntent().getStringExtra("direccion");
        String telefono = getIntent().getStringExtra("telefono");
        String correo = getIntent().getStringExtra("correo");
        boolean servicios1 = getIntent().getBooleanExtra("local", false);
        boolean servicios2 = getIntent().getBooleanExtra("delivery", false);
        boolean plato1 = getIntent().getBooleanExtra("gallina", false);
        boolean plato2 = getIntent().getBooleanExtra("chancho", false);
        boolean plato3 = getIntent().getBooleanExtra("aji", false);
        boolean plato4 = getIntent().getBooleanExtra("pavita", false);
        boolean bebida1 = getIntent().getBooleanExtra("chicha", false);
        boolean bebida2 = getIntent().getBooleanExtra("gaseosa", false);
        boolean bebida3 = getIntent().getBooleanExtra("pisco", false);
        boolean bebida4 = getIntent().getBooleanExtra("vino", false);
        String listaSeleccionada = getIntent().getStringExtra("postres");

        // Crear una cadena con los platos y bebidas seleccionadas
        StringBuilder seleccionados = new StringBuilder();

        if (plato1) seleccionados.append("Gallina criolla\n");
        if (plato2) seleccionados.append("Chancho frito\n");
        if (plato3) seleccionados.append("Ají de gallina\n");
        if (plato4) seleccionados.append("Pavita mechada\n");

        if (bebida1) seleccionados.append("Chicha\n");
        if (bebida2) seleccionados.append("Gaseosa\n");
        if (bebida3) seleccionados.append("Pisco\n");
        if (bebida4) seleccionados.append("Vino\n");

        // Creación de la cadena de resultados
        String resultados = "DIRECCIÓN: " + direccion + "\nTELÉFONO: " + telefono + "\nCORREO: " + correo +
                "\nSERVICIOS: " + (servicios1 ? "Consumo en el Local" : servicios2 ? "Delivery" : "No especificado") +
                "\nPLATOS Y BEBIDAS SELECCIONADOS:\n" + (seleccionados.length() > 0 ? seleccionados.toString() : "No se seleccionaron platos ni bebidas") +
                "\nPostres: " + listaSeleccionada;

        nombre.setText(getIntent().getStringExtra("nombre"));
        textView14.setText(resultados);

        terminar = findViewById(R.id.terminar);
        terminar.setOnClickListener(v -> {
            Intent intent = new Intent(PlatillosActivity.this, FormularioActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

