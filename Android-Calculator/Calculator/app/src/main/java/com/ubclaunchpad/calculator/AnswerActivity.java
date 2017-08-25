package com.ubclaunchpad.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class AnswerActivity extends AppCompatActivity {

    TextView answer;
    TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        answer = (TextView) findViewById(R.id.finalAnswer);
        question = (TextView) findViewById(R.id.question);

        Intent intent = getIntent();
        String input1 = intent.getStringExtra("first");
        String input2 = intent.getStringExtra("second");
        String oppCode = intent.getStringExtra("operation");

        double value1 = Double.valueOf(input1);
        double value2 = Double.valueOf(input2);

        switch (oppCode){
            case "add":
                double resultAdd = value1 + value2;
                question.setText(value1 + " + " + value2);
                answer.setText((Double.toString(resultAdd)));
                break;
            case "sub":
                double resultSub = value1 - value2;
                question.setText(value1 + " - " + value2);
                answer.setText(Double.toString(resultSub));
                break;
            case "multi":
                double resultMulti = value1 * value2;
                question.setText(value1 + " x " + value2);
                answer.setText(Double.toString(resultMulti));
                break;
            case "div":
                if(value2==0){
                    Toast.makeText(getApplicationContext(),"Division by zero",Toast.LENGTH_LONG).show();
                    return;
                }
                DecimalFormat twoDForm = new DecimalFormat("####.####");
                double resultDiv = value1 / value2;
                resultDiv = Double.valueOf(twoDForm.format(resultDiv));
                question.setText(value1 + " ÷ " + value2);
                answer.setText(Double.toString(resultDiv));
                break;
            default:{
                break;
            }
        }
    }
}
