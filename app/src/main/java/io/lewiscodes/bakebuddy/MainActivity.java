package io.lewiscodes.bakebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.lewiscodes.bakebuddy.conversions.Converter;
import io.lewiscodes.bakebuddy.conversions.Ingredient;
import io.lewiscodes.bakebuddy.conversions.Unit;

public class MainActivity extends AppCompatActivity {

    private Button calculateBtn;
    private Button resetBtn;

    private EditText ingredient;
    private EditText unit;
    private EditText convertibleAmount;

    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateBtn = findViewById(R.id.calculate_btn);
        resetBtn = findViewById(R.id.reset_btn);

        ingredient = findViewById(R.id.ingredient);
        unit = findViewById(R.id.unit);
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