package com.ubclaunchpad.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = CalculatorActivity.class.getSimpleName();


    // Declare View objects
    EditText firstInput, secondInput;
    Button plus,minus,multiply,divide;

    // Declare second activity
    Intent answerActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // Declare second activity
        answerActivity = new Intent(CalculatorActivity.this,AnswerActivity.class);


        firstInput = (EditText) findViewById(R.id.firstInput);
        secondInput = (EditText) findViewById(R.id.secondInput);

        plus = (Button) findViewById(R.id.operation_add);
        minus = (Button) findViewById(R.id.operation_sub);
        multiply = (Button) findViewById(R.id.operation_multi);
        divide = (Button) findViewById(R.id.operation_div);


        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);

    }

    /**
     * This implementation of the click listener is for the view found in res/layout/activity_calculator
     * The functions in general should grab the appropriate inputs, and if they are valid, computes the answer.
     * The answer should be displayed in a second activity labelled "AnswerActivity"
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.operation_add:
            {
                if(firstInput.getText().toString().equals("") || secondInput.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"enter values",Toast.LENGTH_SHORT).show();
                    return;
                }
                //TODO add function
                answerActivity.putExtra("first",firstInput.getText().toString());
                answerActivity.putExtra("second",secondInput.getText().toString());
                answerActivity.putExtra("operation","add");
                firstInput.setText("");
                secondInput.setText("");
                CalculatorActivity.this.startActivity(answerActivity);
                break;
            }
            case R.id.operation_sub:
            {
                if(firstInput.getText().toString().equals("") || secondInput.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"enter values",Toast.LENGTH_SHORT).show();
                    return;
                }
                //TODO subtract function
                answerActivity.putExtra("first",firstInput.getText().toString());
                answerActivity.putExtra("second",secondInput.getText().toString());
                answerActivity.putExtra("operation","sub");
                firstInput.setText("");
                secondInput.setText("");
                CalculatorActivity.this.startActivity(answerActivity);
                break;
            }
            case R.id.operation_multi:
            {
                if(firstInput.getText().toString().equals("") || secondInput.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"enter values",Toast.LENGTH_SHORT).show();
                    return;
                }
                //TODO multiply function
                answerActivity.putExtra("first",firstInput.getText().toString());
                answerActivity.putExtra("second",secondInput.getText().toString());
                answerActivity.putExtra("operation","multi");
                firstInput.setText("");
                secondInput.setText("");
                CalculatorActivity.this.startActivity(answerActivity);
                break;
            }
            case R.id.operation_div:
            {
                if(firstInput.getText().toString().equals("") || secondInput.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"enter values",Toast.LENGTH_SHORT).show();
                    return;
                }
                //TODO divide function
                answerActivity.putExtra("first",firstInput.getText().toString());
                answerActivity.putExtra("second",secondInput.getText().toString());
                answerActivity.putExtra("operation","div");
                firstInput.setText("");
                secondInput.setText("");
                CalculatorActivity.this.startActivity(answerActivity);
                break;
            }
            //TODO any extra implmentations (optional)
            default:
            {
                Toast.makeText(this, "Click not implmented yet", Toast.LENGTH_LONG).show();
                Log.e(TAG, "View id: " + v.getId() + " click not implemented yet");
                break;
            }
        }
    }
}
