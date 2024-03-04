package com.kikesf.androidadventures.imcApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kikesf.androidadventures.R;
import com.kikesf.androidadventures.util.Constants;

import java.util.Locale;

public class IMCActivity extends AppCompatActivity {
    private AppCompatButton btnCalculateIMC;
    private CardView cardFemale, cardMale;
    private EditText inputHeight;
    private TextView weightText, ageText;
    private Button addWeight, addAge, substractAge, substractWeight;
    private boolean isSelected;
    private double initialWeight = 60;
    private byte initialAge = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        initComponents();
        initiListeners();
    }

    private void initComponents() {
        cardFemale = findViewById(R.id.card_female);
        cardMale = findViewById(R.id.card_male);
        inputHeight = findViewById(R.id.label_height);
        btnCalculateIMC = findViewById(R.id.btn_calculate_imc);
        weightText = findViewById(R.id.weight_text);
        ageText = findViewById(R.id.age_text);
        addWeight = findViewById(R.id.btn_add_weight);
        addAge = findViewById(R.id.btn_add_age);
        substractAge = findViewById(R.id.btn_subtract_age);
        substractWeight = findViewById(R.id.btn_subtract_weight);

        setWeight(initialWeight);
        setAge(initialAge);
    }

    private void initiListeners() {
        cardFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSelected = true;
                setBackgroundCard(isSelected);
            }
        });

        cardMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSelected = false;
                setBackgroundCard(isSelected);
            }
        });

        addWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialWeight += 1;
                setWeight(initialWeight);
            }
        });

        substractWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialWeight -= 1;
                setWeight(initialWeight);
            }
        });

        addAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialAge += 1;
                setAge(initialAge);
            }
        });

        substractAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialAge -= 1;
                setAge(initialAge);
            }
        });

        btnCalculateIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = String.format(Locale.forLanguageTag("es-MX"), "%.2f", resultIMC());
                Log.i("kikeDev", result);
                navigateToActivity(ResultIMCActivity.class, resultIMC());
            }
        });
    }

    private void navigateToActivity(Class<?> activityClass, double resultIMC) {
        Intent intent = new Intent(IMCActivity.this, activityClass);
        intent.putExtra(Constants.IMC_RESULT, resultIMC);
        startActivity(intent);
    }

    private void setAge(byte initialAge) {
        String formattedAge = initialAge + "years";
        ageText.setText(formattedAge);
    }

    private void setWeight(double initialWeight) {
        String formattedWeight = String.format(Locale.forLanguageTag("es-MX"), "%.0f kg", initialWeight);
        weightText.setText(formattedWeight);
    }

    private int getColorResource(int colorResource) {
        return ContextCompat.getColor(this, colorResource);
    }

    private void setBackgroundCard(boolean isSelected) {
        int selectedColor = getColorResource(R.color.slate_600);
        int unselectedColor = getColorResource(R.color.slate_800);

        if (isSelected) {
            cardFemale.setCardBackgroundColor(selectedColor);
            cardMale.setCardBackgroundColor(unselectedColor);
        } else {
            cardFemale.setCardBackgroundColor(unselectedColor);
            cardMale.setCardBackgroundColor(selectedColor);
        }
    }

    private double resultIMC() {
        try {
            String weightStr = weightText.getText().toString();
            int weight = Integer.parseInt(weightStr.replaceAll("[^\\d.]", ""));
            double height = Double.parseDouble(inputHeight.getText().toString()) / 100;

            if (height == 0) return 0.0;

            return weight / Math.pow(height, 2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}