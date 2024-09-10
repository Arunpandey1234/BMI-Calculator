package com.app.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        TextView txtResult;
        EditText edtWeight, edtHeightFT, edtHeightIN;
        Button btmCalculate, btmReset;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.editWeight);
        edtHeightFT = findViewById(R.id.edtHeightFT);
        edtHeightIN = findViewById(R.id.edtHeightIN);
        btmCalculate = findViewById(R.id.btmCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);
        btmReset = findViewById(R.id.btmReset);  // Initialize reset button

        // Button click listener to calculate BMI
        btmCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get weight and height from user input
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFT.getText().toString());
                int in = Integer.parseInt(edtHeightIN.getText().toString());

                // Calculate total inches, cm, and meters
                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;

                // Calculate BMI
                double bmi = wt / (totalM * totalM);

                // Set result based on BMI
                if (bmi > 25) {
                    txtResult.setText("You are Overweight");
                    llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorOW));
                } else if (bmi < 18) {
                    txtResult.setText("You are Underweight");
                    llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorUW));
                } else {
                    txtResult.setText("You are Healthy");
                    llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorH));
                }
            }
        });

        // Button click listener to reset the input fields and result
        btmReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear the input fields
                edtWeight.setText("");
                edtHeightFT.setText("");
                edtHeightIN.setText("");

                // Reset the result text and background color
                txtResult.setText("Result");
                llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
            }
        });
    }
}
