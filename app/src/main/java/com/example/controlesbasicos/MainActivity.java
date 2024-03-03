package com.example.controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;
    Button btn;
    RadioGroup opt;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                tempVal = findViewById(R.id.txtnum1);
                double num1 = Double.parseDouble(tempVal.getText().toString());

                tempVal = findViewById(R.id.txtnum2);
                double num2 = Double.parseDouble(tempVal.getText().toString());

                double respuesta = 0;
                opt = findViewById(R.id.optOpciones);
                int checkedRadioButtonId = opt.getCheckedRadioButtonId();

                switch (checkedRadioButtonId) {
                    case R.id.optSuma:
                        respuesta = num1 + num2;
                        break;
                    case R.id.optResta:
                        respuesta = num1 - num2;
                        break;
                    case R.id.optMultiplicacion:
                        respuesta = num1 * num2;
                        break;
                    case R.id.optDivision:
                        respuesta = num1 / num2;
                        break;
                    default:
                        break;
                }

                spn = findViewById(R.id.spnOpciones);
                int selectedItemPosition = spn.getSelectedItemPosition();

                switch (selectedItemPosition) {
                    case 0:
                        respuesta = num1 + num2;
                        break;
                    case 1:
                        respuesta = num1 - num2;
                        break;
                    case 2:
                        respuesta = num1 * num2;
                        break;
                    case 3:
                        respuesta = num1 / num2;
                        break;
                    default:
                        break;
                }

                tempVal = findViewById(R.id.lblrespuesta);
                tempVal.setText("Respuesta: " + respuesta);
            }
        });
    }
}
