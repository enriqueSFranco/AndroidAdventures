package com.kikesf.androidadventures.imcApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kikesf.androidadventures.R;
import com.kikesf.androidadventures.util.Constants;

public class ResultIMCActivity extends AppCompatActivity {
    private Button recalculate;
    private TextView informationText, statusIMCText, resultIMCText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_imc);

        initComponents();
        initListeners();

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(Constants.IMC_RESULT)) {
            double result = intent.getDoubleExtra(Constants.IMC_RESULT, 0.0);
            initUI(result);
        }
    }

    private void initUI(double resultIMC) {
        resultIMCText.setText(resultIMCText.getText());
        if (resultIMC < 18.5) {
            statusIMCText.setText("Bajo peso");
            informationText.setText("Peso por debajo del rango considerado saludable.");
        }
        else if (resultIMC > 18.5 && resultIMC < 24.9) {
            statusIMCText.setText("Peso saludable");
            informationText.setText("Peso considerado saludable.");
        }
        else if (resultIMC > 25.0 && resultIMC < 29.9) {
            statusIMCText.setText("Sobrepeso");
            informationText.setText("Peso por encima del rango considerado saludable.");
        }
        else {
            statusIMCText.setText("Obesidad");
            informationText.setText("Riesgo alto para problemas de salud.");
        }
    }

    private void initComponents() {
        recalculate = findViewById(R.id.btn_recalculate);
        informationText = findViewById(R.id.information_text);
        statusIMCText = findViewById(R.id.text_status_imc);
        resultIMCText = findViewById(R.id.text_result_imc);
    }

    private void initListeners() {
        recalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}