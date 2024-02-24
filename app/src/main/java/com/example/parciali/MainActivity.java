package com.example.parciali;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMetros;
    private TextView textViewResultado;

    private Spinner spinnerUnidades;
    private EditText editTextValorArea;
    private TextView textViewResultadoArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMetros = findViewById(R.id.editTextMetros);
        textViewResultado = findViewById(R.id.textViewResultado);

        spinnerUnidades = findViewById(R.id.spinnerUnidades);
        editTextValorArea = findViewById(R.id.editTextValorArea);
        textViewResultadoArea = findViewById(R.id.textViewResultadoArea);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.unidades_area,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnidades.setAdapter(adapter);

        spinnerUnidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    public void calcularCosto(View view) {
        String metrosStr = editTextMetros.getText().toString();

        if (!metrosStr.isEmpty()) {
            double metros = Double.parseDouble(metrosStr);

            double[] tarifas = {0.45, 0.65};

            double costo;
            if (metros <= 18) {
                costo = 6;
            } else if (metros <= 28) {
                costo = 6 + (metros - 18) * 0.45;
            } else {
                double costoExceso28 = (metros - 28) * 0.65;
                double costoHasta28 = 10 * 0.45;
                costo = 6 + costoHasta28 + costoExceso28;
            }

            textViewResultado.setText("Cuota fija: $6\nEl costo del agua es: $" + costo);
        } else {
            textViewResultado.setText("Ingresa la cantidad de metros cúbicos.");
        }
    }


    public void convertirArea(View view) {
        String unidadSeleccionada = spinnerUnidades.getSelectedItem().toString();

        String valorStr = editTextValorArea.getText().toString();

        if (!valorStr.isEmpty()) {
            double valor = Double.parseDouble(valorStr);

            double resultado = convertirUnidadArea(valor, unidadSeleccionada);

            textViewResultadoArea.setText("Resultado: " + resultado + " m²");
        } else {
            textViewResultadoArea.setText("Ingresa un valor.");
        }
    }

    private double convertirUnidadArea(double valor, String unidad) {
        switch (unidad) {
            case "Pie Cuadrado":
                return valor * 0.092903;
            case "Vara Cuadrada":
                return valor * 0.698779;
            case "Yarda Cuadrada":
                return valor * 0.836127;
            case "Metro Cuadrado":
                return valor;
            case "Tareas":
                return valor * 1000;
            case "Manzana":
                return valor * 10000;
            case "Hectárea":
                return valor * 10000;
            default:
                return valor;
        }
    }
    public void cambiarAPestana1(View view) {
        findViewById(R.id.tab1).setVisibility(View.VISIBLE);
        findViewById(R.id.tab2).setVisibility(View.GONE);
    }

    public void cambiarAPestana2(View view) {
        findViewById(R.id.tab1).setVisibility(View.GONE);
        findViewById(R.id.tab2).setVisibility(View.VISIBLE);
    }
}
