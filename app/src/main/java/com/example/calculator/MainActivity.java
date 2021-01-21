package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mCalcTextView;

    private Button mButton_0;
    private Button mButton_1;
    private Button mButton_2;
    private Button mButton_3;
    private Button mButton_4;
    private Button mButton_5;
    private Button mButton_6;
    private Button mButton_7;
    private Button mButton_8;
    private Button mButton_9;

    private Button mButton_plus;
    private Button mButton_minus;
    private Button mButton_multiplication;
    private Button mButton_division;
    private Button mButton_equal;
    private Button mButton_percent;

    private Button mButton_comma;//запятая
    private Button mButton_plus_minus;//(+/-)
    private Button mButton_coup;// 1/x
    private Button mButton_square;// x^2
    private Button mButton_root;// sqrt(x)

    private Button mButton_clear_all;
    private Button mButton_clear_x;
    private ImageButton mButton_clear_last;


    private Nums button = new Nums();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalcTextView = (TextView)findViewById(R.id.action_text);

        mButton_0 = (Button)findViewById(R.id.button_0);
        mButton_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getCounter() < 9){
                    mCalcTextView.setText(button.numButton(button.getAct(), 0));
                    button.setCounter(button.getCounter() + 1);
                }
            }
        });

        mButton_1 = (Button)findViewById(R.id.button_1);
        mButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getCounter() < 9){
                    mCalcTextView.setText(button.numButton(button.getAct(), 1));
                    button.setCounter(button.getCounter() + 1);
                }
            }
        });

        mButton_2 = (Button)findViewById(R.id.button_2);
        mButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getCounter() < 9){
                    mCalcTextView.setText(button.numButton(button.getAct(), 2));
                    button.setCounter(button.getCounter() + 1);
                }
            }
        });

        mButton_3 = (Button)findViewById(R.id.button_3);
        mButton_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getCounter() < 9){
                    mCalcTextView.setText(button.numButton(button.getAct(), 3));
                    button.setCounter(button.getCounter() + 1);
                }
            }
        });

        mButton_4 = (Button)findViewById(R.id.button_4);
        mButton_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getCounter() < 9){
                    mCalcTextView.setText(button.numButton(button.getAct(), 4));
                    button.setCounter(button.getCounter() + 1);
                }
            }
        });

        mButton_5 = (Button)findViewById(R.id.button_5);
        mButton_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getCounter() < 9){
                    mCalcTextView.setText(button.numButton(button.getAct(), 5));
                    button.setCounter(button.getCounter() + 1);
                }
            }
        });

        mButton_6 = (Button)findViewById(R.id.button_6);
        mButton_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getCounter() < 9){
                    mCalcTextView.setText(button.numButton(button.getAct(), 6));
                    button.setCounter(button.getCounter() + 1);
                }
            }
        });

        mButton_7 = (Button)findViewById(R.id.button_7);
        mButton_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getCounter() < 9){
                    mCalcTextView.setText(button.numButton(button.getAct(), 7));
                    button.setCounter(button.getCounter() + 1);
                }
            }
        });

        mButton_8 = (Button)findViewById(R.id.button_8);
        mButton_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getCounter() < 9){
                    mCalcTextView.setText(button.numButton(button.getAct(), 8));
                    button.setCounter(button.getCounter() + 1);
                }
            }
        });

        mButton_9 = (Button)findViewById(R.id.button_9);
        mButton_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getCounter() < 9){
                    mCalcTextView.setText(button.numButton(button.getAct(), 9));
                    button.setCounter(button.getCounter() + 1);
                }
            }
        });


        mButton_plus = (Button)findViewById(R.id.button_plus);
        mButton_plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                button.operationPlus();
            }
        });

        mButton_minus = (Button)findViewById(R.id.button_minus);
        mButton_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.operationSubtraction();
            }
        });
        mButton_multiplication = (Button)findViewById(R.id.button_multiplication);
        mButton_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.operationMultiplication();
            }
        });
        mButton_division = (Button)findViewById(R.id.button_div);
        mButton_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.operationDivision();
            }
        });

        mButton_equal = (Button)findViewById(R.id.button_equal);
        mButton_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationEqual());
            }
        });

        mButton_plus_minus = (Button)findViewById(R.id.button_pm);
        mButton_plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationPlusMinus(button.getAct()));
            }
        });

        mButton_percent = (Button)findViewById(R.id.button_percent);
        mButton_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationPercent(button.getAct()));
            }
        });

        mButton_comma = (Button)findViewById(R.id.button_com);
        mButton_coup = (Button)findViewById(R.id.button_coup);
        mButton_coup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationCoup(button.getAct()));
            }
        });

        mButton_square = (Button)findViewById(R.id.button_square);
        mButton_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationSquare(button.getAct()));
            }
        });

        mButton_root = (Button)findViewById(R.id.button_root);
        mButton_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationSqrt(button.getAct()));
            }
        });

        mButton_clear_last = (ImageButton)findViewById(R.id.button_clear_last);
        mButton_clear_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationClearLastSymbol(button.getAct()));
            }
        });

        mButton_clear_x = (Button)findViewById(R.id.button_clear_x);
        mButton_clear_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationClearXorY(button.getAct()));
            }
        });

        mButton_clear_all = (Button)findViewById(R.id.button_clear_all);
        mButton_clear_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationClearAll());
            }
        });
    }
}
