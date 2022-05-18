package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import tk.pratanumandal.expr4j.ExpressionEvaluator;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private final ExpressionEvaluator evaluator = new ExpressionEvaluator();
    private static final String INVALID = "Invalid Expression";
    TextView expressionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(com.google.android.material.R.style.Theme_AppCompat_Light);
        setContentView(R.layout.activity_calculator);
        super.onCreate(savedInstanceState);
        this.expressionTextView = findViewById(R.id.calculatorExpressionTextView);
        findViewById(R.id.calculatorClearAllButton).setOnClickListener(this);
        findViewById(R.id.calculatorClearButton).setOnClickListener(this);
        findViewById(R.id.calculator0Button).setOnClickListener(this);
        findViewById(R.id.calculator1Button).setOnClickListener(this);
        findViewById(R.id.calculator2Button).setOnClickListener(this);
        findViewById(R.id.calculator3Button).setOnClickListener(this);
        findViewById(R.id.calculator4Button).setOnClickListener(this);
        findViewById(R.id.calculator5Button).setOnClickListener(this);
        findViewById(R.id.calculator6Button).setOnClickListener(this);
        findViewById(R.id.calculator7Button).setOnClickListener(this);
        findViewById(R.id.calculator8Button).setOnClickListener(this);
        findViewById(R.id.calculator9Button).setOnClickListener(this);
        findViewById(R.id.calculatorAdditionButton).setOnClickListener(this);
        findViewById(R.id.calculatorSubtractionButton).setOnClickListener(this);
        findViewById(R.id.calculatorDivisionButton).setOnClickListener(this);
        findViewById(R.id.calculatorModulusButton).setOnClickListener(this);
        findViewById(R.id.calculatorMultiplyButton).setOnClickListener(this);
        findViewById(R.id.calculatorPointButton).setOnClickListener(this);
        findViewById(R.id.calculatorEqualsButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String expression = "";
        if (view.getId() == R.id.calculatorClearAllButton) {
            expression = "";
        } else if (view.getId() == R.id.calculatorClearButton) {
            expression = this.trimRight(this.getExpression());
        } else if (view.getId() == R.id.calculator0Button) {
            expression = this.getExpression().concat("0");
        } else if (view.getId() == R.id.calculator1Button) {
            expression = this.getExpression().concat("1");
        } else if (view.getId() == R.id.calculator2Button) {
            expression = this.getExpression().concat("2");
        } else if (view.getId() == R.id.calculator3Button) {
            expression = this.getExpression().concat("3");
        } else if (view.getId() == R.id.calculator4Button) {
            expression = this.getExpression().concat("4");
        } else if (view.getId() == R.id.calculator5Button) {
            expression = this.getExpression().concat("5");
        } else if (view.getId() == R.id.calculator6Button) {
            expression = this.getExpression().concat("6");
        } else if (view.getId() == R.id.calculator7Button) {
            expression = this.getExpression().concat("7");
        } else if (view.getId() == R.id.calculator8Button) {
            expression = this.getExpression().concat("8");
        } else if (view.getId() == R.id.calculator9Button) {
            expression = this.getExpression().concat("9");
        } else if (view.getId() == R.id.calculatorModulusButton) {
            expression = this.getExpression().concat("%");
        } else if (view.getId() == R.id.calculatorAdditionButton) {
            expression = this.getExpression().concat("+");
        } else if (view.getId() == R.id.calculatorMultiplyButton) {
            expression = this.getExpression().concat("*");
        } else if (view.getId() == R.id.calculatorSubtractionButton) {
            expression = this.getExpression().concat("-");
        } else if (view.getId() == R.id.calculatorDivisionButton) {
            expression = this.getExpression().concat("/");
        } else if (view.getId() == R.id.calculatorPointButton) {
            expression = this.getExpression().concat(".");
        } else if (view.getId() == R.id.calculatorEqualsButton) {
            this.evaluateExpression();
        }
        this.setExpression(expression);
    }

    public void evaluateExpression() {
        try {
            double result = evaluator.evaluate(this.getExpression());
            Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT);
            toast.show();
            Log.d("CalculatorActivity", String.valueOf(result));
            this.setExpression(String.valueOf(result));
        } catch (Exception ignored) {
            this.setExpression(INVALID);
            Toast toast = Toast.makeText(getApplicationContext(), INVALID, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public String getExpression() {
        return (String) this.expressionTextView.getText();
    }

    public void setExpression(String expression) {
        this.expressionTextView.setText(this.createExpression(expression));
    }

    public String createExpression(String str) {
        return this.getString(R.string.calculator_expressions, str);
    }

    public String trimRight(String str) {
        if (str.length() > 0)
            str = str.substring(0, str.length() - 1);
        return str;
    }
}