package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private Button mButton_cls;
    private Button mButton_clear;
    private Button mButton_comma;//запятая
    private Button mButton_plus_minus;//(+/-)

    private Nums button = new Nums();

    private double x, y;
    private String str;
    private Integer xInt, yInt;
    private boolean isAct = false;




    int plus = 0;
    int subtraction = 0;
    int multiplication = 0;
    int division = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalcTextView = (TextView)findViewById(R.id.action_text_view);

        mButton_0 = (Button)findViewById(R.id.button_0);
        mButton_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.numButton(button.getAct(), 0));
            }
        });

        mButton_1 = (Button)findViewById(R.id.button_1);
        mButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.numButton(button.getAct(), 1));
            }
        });

        mButton_2 = (Button)findViewById(R.id.button_2);
        mButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.numButton(button.getAct(), 2));
            }
        });

        mButton_3 = (Button)findViewById(R.id.button_3);
        mButton_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.numButton(button.getAct(), 3));
            }
        });

        mButton_4 = (Button)findViewById(R.id.button_4);
        mButton_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.numButton(button.getAct(), 4));
            }
        });

        mButton_5 = (Button)findViewById(R.id.button_5);
        mButton_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.numButton(button.getAct(), 5));
            }
        });

        mButton_6 = (Button)findViewById(R.id.button_6);
        mButton_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.numButton(button.getAct(), 6));
            }
        });

        mButton_7 = (Button)findViewById(R.id.button_7);
        mButton_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.numButton(button.getAct(), 7));
            }
        });

        mButton_8 = (Button)findViewById(R.id.button_8);
        mButton_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.numButton(button.getAct(), 8));
            }
        });

        mButton_9 = (Button)findViewById(R.id.button_9);
        mButton_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.numButton(button.getAct(), 9));
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
        mButton_cls = (Button)findViewById(R.id.button_cls);
        mButton_cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 mCalcTextView.setText(button.operationClearLastSymbol(button.getAct()));
            }
        });
        mButton_comma = (Button)findViewById(R.id.button_com);
        mButton_comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        mButton_clear = (Button)findViewById(R.id.button_C);
        mButton_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationClearAll());
            }
        });

        mButton_plus_minus = (Button)findViewById(R.id.button_pm);
        mButton_plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationPlusMinus(button.getAct()));
            }
        });

        mButton_equal = (Button)findViewById(R.id.button_equal);
        mButton_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalcTextView.setText(button.operationEqual());
            }
        });
    }
}
