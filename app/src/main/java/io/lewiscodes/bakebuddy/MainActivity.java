package io.lewiscodes.bakebuddy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

    private TextView results;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateBtn = findViewById(R.id.calculate_btn);
        resetBtn = findViewById(R.id.reset_btn);

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

        convertibleAmount = findViewById(R.id.convertible_amount);

        results = findViewById(R.id.results);

        calculateBtn.setOnClickListener((v) -> {
            results.setText(performCalculation());
        });
        resetBtn.setOnClickListener((v) -> {
            Toast.makeText(this, "Reset button pressed", Toast.LENGTH_SHORT).show();
        });
    }

    private String performCalculation() {
        return new Converter(
                Ingredient.FLOUR,
                Unit.CUP,
                true,
                2.0
        ).formattedResult();
    }
}