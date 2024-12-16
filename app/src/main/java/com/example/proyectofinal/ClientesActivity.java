package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ClientesActivity extends AppCompatActivity {
    Button finalizar;
    TextView textView13;
    EditText nombre1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clientes);

        textView13 = findViewById(R.id.textView13);
        nombre1 = findViewById(R.id.nombre1);

        String apellidos = getIntent().getStringExtra("apellidos");
        String celular = getIntent().getStringExtra("celular");
        String correo1 = getIntent().getStringExtra("correo1");

        // Encrypt the clave
        String clave = getIntent().getStringExtra("clave");
        String encryptedClave = encryptClave(clave);

        boolean estado = getIntent().getBooleanExtra("masculino", false);

        String listaSeleccionada = getIntent().getStringExtra("nacionalidad");

        String genero = estado ? "Masculino" : "Femenino";

        String resultados = "APELLIDOS : "             + apellidos +
                            "\nCELULAR : "             + celular +
                            "\nCORREO : "              + correo1 +
                            "\nCLAVE (Encriptada) : "  + encryptedClave +
                            "\nNACIONALIDAD : "        + listaSeleccionada +
                            "\nSEXO : "                + genero;

        nombre1.setText(getIntent().getStringExtra("nombre1"));
        textView13.setText(resultados);

        finalizar = findViewById(R.id.finalizar);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private String encryptClave(String clave) {
        String encryptedClave = "";
        try {
            // Replace "your-secret-key" with a 16-character key for AES
            SecretKeySpec keySpec = new SecretKeySpec("your-secret-key".getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encryptedValue = cipher.doFinal(clave.getBytes());
            encryptedClave = Base64.encodeToString(encryptedValue, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedClave;
    }
}
