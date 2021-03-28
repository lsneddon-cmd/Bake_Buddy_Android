package io.lewiscodes.bakebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        calculateBtn.setOnClickListener((v) -> {
            Toast.makeText(this, "Calculate button pressed", Toast.LENGTH_SHORT).show();
        });
        resetBtn.setOnClickListener((v) -> {
            Toast.makeText(this, "Reset button pressed", Toast.LENGTH_SHORT).show();
        });
    }
}