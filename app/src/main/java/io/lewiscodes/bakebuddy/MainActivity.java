package io.lewiscodes.bakebuddy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import io.lewiscodes.bakebuddy.conversions.Converter;
import io.lewiscodes.bakebuddy.conversions.Ingredient;
import io.lewiscodes.bakebuddy.conversions.Unit;

public class MainActivity extends AppCompatActivity {

    private Button calculateBtn;
    private Button resetBtn;

    private Spinner ingredient;
    private Spinner unit;

    private EditText convertibleAmount;

    private boolean isImperial = true;

    private TextView results;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();
        initSpinners();

        convertibleAmount = findViewById(R.id.convertible_amount);
        results = findViewById(R.id.results);

        calculateBtn.setOnClickListener((v) -> {
            results.setText(performCalculation());
        });
        resetBtn.setOnClickListener((v) -> {
            Toast.makeText(this, "Reset button pressed", Toast.LENGTH_SHORT).show();
        });
    }

    private void initSpinners() {
        ingredient = findViewById(R.id.ingredient);
        ArrayAdapter<Ingredient> adapterIngredients =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        Ingredient.values());

        adapterIngredients.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ingredient.setAdapter(adapterIngredients);

        unit = findViewById(R.id.unit);
        ArrayAdapter<Unit> adapterUnit =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        Unit.values());
        adapterUnit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit.setAdapter(adapterUnit);
    }

    private void initButtons() {
        calculateBtn = findViewById(R.id.calculate_btn);
        resetBtn = findViewById(R.id.reset_btn);
    }

    private String performCalculation() {
        Ingredient selectedIngredient = (Ingredient) ingredient.getSelectedItem();
        Unit selectedUnit = (Unit) unit.getSelectedItem();
        double amount = convertibleAmount != null ? Double.parseDouble(convertibleAmount.getText().toString()) : 0.0;
        return new Converter(
                selectedIngredient,
                selectedUnit,
                isImperial,
                amount
        ).formattedResult();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_imperial:
                if (checked)
                    isImperial = true;
                    break;
            case R.id.radio_us_legal:
                if (checked)
                    isImperial = false;
                    break;
        }
    }
}