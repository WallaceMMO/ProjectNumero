/*
 *@author:<Wallace Moura Machado de Oliveira;1110482413004>
 */
package com.example.projectnumero;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtNumero;
    TextView lblCentena;
    TextView lblDezena;
    TextView lblUnidade;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero = findViewById(R.id.txtNumero);
        lblCentena = findViewById(R.id.lblCentena);
        lblDezena = findViewById(R.id.lblDezena);
        lblUnidade = findViewById(R.id.lblUnidade);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }

    private void calcular() {
        String numeroStr = txtNumero.getText().toString();
        if (numeroStr.isEmpty()) {
            Toast.makeText(this, "Por favor, insira um número.", Toast.LENGTH_SHORT).show();
            return;
        }

        int numero = Integer.parseInt(numeroStr);

        if (numero < 100 || numero > 999) {
            Toast.makeText(this, "O número deve estar entre 100 e 999.", Toast.LENGTH_SHORT).show();
            return;
        }

        int centena = numero / 100;
        int dezena = (numero % 100) / 10;
        int unidade = numero % 10;

        lblCentena.setText("CENTENA = " + centena);
        lblDezena.setText("DEZENA = " + dezena);
        lblUnidade.setText("UNIDADE = " + unidade);
    }
}