package com.arukane.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.scijava.parse.eval.DefaultEvaluator;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity
{
    TextView screen;
    Button add,minus,multiply,divide,zero,zero2,dot,clear,
    erase,percent,equals,one,two,three,four,five,six,seven,eight,nine;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //No ActionBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        try {
            //Switches
            AtomicBoolean dotSwitch = new AtomicBoolean(false);
            AtomicBoolean operatorSwitch = new AtomicBoolean(true);
            AtomicBoolean zeroSwitch = new AtomicBoolean(false);
            AtomicBoolean dotTrigger = new AtomicBoolean(false);

            //Components
            screen = (TextView) findViewById(R.id.screen);

            add = (Button) findViewById(R.id.plus);
            add.setOnClickListener(view ->
            {
                if (screen.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                    return;
                } else if (operatorSwitch.get() == false) {
                    if (screen.getText().toString().endsWith(".")) {
                        Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                    } else {
                        screen.setText(screen.getText().toString() + "+");
                        dotSwitch.set(true);
                        operatorSwitch.set(true);
                        dotTrigger.set(false);
                    }
                }



            });

            minus = (Button) findViewById(R.id.minus);
            minus.setOnClickListener(view ->
            {
                if (screen.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                    return;
                } else if (operatorSwitch.get() == false) {
                    if (screen.getText().toString().endsWith(".")) {
                        Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                    } else {
                        screen.setText(screen.getText().toString() + "-");
                        dotSwitch.set(true);
                        operatorSwitch.set(true);
                        dotTrigger.set(false);
                    }
                }
            });

            multiply = (Button) findViewById(R.id.multiply);
            multiply.setOnClickListener(view ->
            {
                if (screen.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                    return;
                } else if (operatorSwitch.get() == false) {
                    if (screen.getText().toString().endsWith(".")) {
                        Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                    } else {
                        screen.setText(screen.getText().toString() + "×");
                        dotSwitch.set(true);
                        operatorSwitch.set(true);
                        dotTrigger.set(false);
                    }
                }
            });

            divide = (Button) findViewById(R.id.divide);
            divide.setOnClickListener(view ->
            {
                if (screen.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                    return;
                } else if (operatorSwitch.get() == false) {
                    if (screen.getText().toString().endsWith(".")) {
                        Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                    } else {
                        screen.setText(screen.getText().toString() + "÷");
                        dotSwitch.set(true);
                        operatorSwitch.set(true);
                        dotTrigger.set(false);
                    }
                }
            });

            zero = (Button) findViewById(R.id.zero);
            zero.setOnClickListener(view ->
            {
                if (screen.getText().toString().matches("\\d+")) {
                    if (zeroSwitch.get() == true) {
                        screen.setText(screen.getText().toString() + "0");
                        zeroSwitch.set(false);
                    }
                    if (zeroSwitch.get() == false) {
                        screen.setText(screen.getText().toString() + "0");
                        zeroSwitch.set(false);
                    }
                } else if (screen.getText().toString().endsWith(".") ||
                        screen.getText().toString().endsWith("+") ||
                        screen.getText().toString().endsWith("-") ||
                        screen.getText().toString().endsWith("×") ||
                        screen.getText().toString().endsWith("÷")) {
                    Toast.makeText(getApplicationContext(), "Invalid input!", Toast.LENGTH_LONG).show();
                } else {
                    screen.setText(screen.getText().toString() + "0");
                    zeroSwitch.set(false);
                }
            });

            zero2 = (Button) findViewById(R.id.zero2);
            zero2.setOnClickListener(view ->
            {
                if (screen.getText().toString().matches("\\d+")) {
                    screen.setText(screen.getText().toString() + "00");
                    operatorSwitch.set(false);
                    dotSwitch.set(false);
                } else if (screen.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Invalid input!", Toast.LENGTH_LONG).show();
                } else if (screen.getText().toString().endsWith(".") ||
                        screen.getText().toString().endsWith("+") ||
                        screen.getText().toString().endsWith("-") ||
                        screen.getText().toString().endsWith("×") ||
                        screen.getText().toString().endsWith("÷")) {
                    Toast.makeText(getApplicationContext(), "Invalid input!", Toast.LENGTH_LONG).show();
                } else {
                    screen.setText(screen.getText().toString() + "0");
                    dotSwitch.set(true);
                }
            });

            dot = (Button) findViewById(R.id.dot);
            dot.setOnClickListener(view ->
            {
                if (dotTrigger.get() == false) {
                    if (screen.getText().toString().matches("\\d+")) {
                        if (dotSwitch.get() == false) {
                            screen.setText(screen.getText().toString() + ".");
                            dotSwitch.set(true);
                            dotTrigger.set(true);
                        }
                    } else if (screen.getText().toString().matches("")) {
                        Toast.makeText(getApplicationContext(), "Invalid input!", Toast.LENGTH_LONG).show();
                    } else if (screen.getText().toString().endsWith(".") ||
                            screen.getText().toString().endsWith("+") ||
                            screen.getText().toString().endsWith("-") ||
                            screen.getText().toString().endsWith("×") ||
                            screen.getText().toString().endsWith("÷")) {
                        Toast.makeText(getApplicationContext(), "Invalid input!", Toast.LENGTH_LONG).show();
                    } else {
                        screen.setText(screen.getText().toString() + ".");
                        dotSwitch.set(true);
                        dotTrigger.set(true);
                    }
                } else if (dotTrigger.get() == false) {
                    screen.setText(screen.getText().toString() + ".");
                    dotSwitch.set(true);
                    dotTrigger.set(true);
                }
            });

            clear = (Button) findViewById(R.id.clear);
            clear.setOnClickListener(view ->
            {
                screen.setText("");
                dotSwitch.set(false);
                operatorSwitch.set(false);
                dotTrigger.set(false);
            });

            erase = (Button) findViewById(R.id.erase);
            erase.setOnClickListener(view ->
            {
                if (screen.getText().toString().endsWith(".") ||
                        screen.getText().toString().endsWith("+") ||
                        screen.getText().toString().endsWith("-") ||
                        screen.getText().toString().endsWith("×") ||
                        screen.getText().toString().endsWith("÷")) {
                    operatorSwitch.set(false);
                    dotTrigger.set(false);
                    dotSwitch.set(false);
                }
                if (screen.getText().toString().matches("\\d+")) {
                    String reverse = new StringBuffer(screen.getText()).reverse().toString();
                    char[] reverseToChar = reverse.toCharArray();
                    char[] reverseHolder = new char[reverseToChar.length - 1];
                    for (int i = 0; i < reverseToChar.length; i++) {
                        if (i == 0) ;
                        else if (i == reverseToChar.length) ;
                        else {
                            reverseHolder[i - 1] = reverseToChar[i];
                        }
                    }

                    String reverseInitial = String.valueOf(reverseHolder);
                    reverse = new StringBuffer(reverseInitial).reverse().toString();
                    screen.setText(reverse);
                } else if (screen.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Nothing to erase!", Toast.LENGTH_LONG).show();
                } else {
                    String text = screen.getText().toString();
                    text = text.substring(0, text.length() - 1);
                    screen.setText(text);
                }
            });

            percent = (Button) findViewById(R.id.percent);
            percent.setOnClickListener(view ->
            {
                if (screen.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                    return;
                }
                String reverse = new StringBuffer(screen.getText()).reverse().toString();
                char[] reverseToChar = reverse.toCharArray();
                boolean percentSwitch = false;

                if (reverseToChar[0] == '+') {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                } else if (reverseToChar[0] == '-') {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                } else if (reverseToChar[0] == '×') {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                } else if (reverseToChar[0] == '÷') {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                } else if (reverseToChar[0] == '.') {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                } else {
                    percentSwitch = true;
                }

                if (percentSwitch == true) {
                    Object result = new DefaultEvaluator().evaluate(screen.getText().toString());
                    double answer = Double.parseDouble(result.toString());
                    answer = answer / 100;
                    String percentageScreen = String.valueOf(answer);
                    screen.setText(percentageScreen);
                    dotTrigger.set(true);
                    dotSwitch.set(true);
                    operatorSwitch.set(false);
                }
            });

            equals = (Button) findViewById(R.id.equals);
            equals.setOnClickListener(view ->
            {
                if (screen.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                    return;
                }
                String reverse = new StringBuffer(screen.getText()).reverse().toString();
                char[] reverseToChar = reverse.toCharArray();

                if (reverseToChar[0] == '+') {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                } else if (reverseToChar[0] == '-') {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                } else if (reverseToChar[0] == '×') {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                } else if (reverseToChar[0] == '÷') {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                } else if (reverseToChar[0] == '.') {
                    Toast.makeText(getApplicationContext(), "Invalid operation!", Toast.LENGTH_LONG).show();
                } else {
                    String answer = screen.getText().toString();
                    char answerChar[] = answer.toCharArray();
                    answer = "";
                    for (int i = 0; i < answerChar.length; i++) {
                        if (answerChar[i] == '×') {
                            answerChar[i] = '*';
                        }
                        if (answerChar[i] == '÷') {
                            answerChar[i] = '/';
                            ;
                        }
                        answer += String.valueOf(answerChar[i]);
                    }
                    Object result = new DefaultEvaluator().evaluate(answer);
                    screen.setText(String.valueOf(result));
                    dotTrigger.set(false);
                    operatorSwitch.set(false);
                }

            });

            one = (Button) findViewById(R.id.one);
            one.setOnClickListener(view ->
            {
                screen.setText(screen.getText().toString() + 1);
                operatorSwitch.set(false);
                dotSwitch.set(false);
            });

            two = (Button) findViewById(R.id.two);
            two.setOnClickListener(view ->
            {
                screen.setText(screen.getText().toString() + 2);
                operatorSwitch.set(false);
                dotSwitch.set(false);
            });

            three = (Button) findViewById(R.id.three);
            three.setOnClickListener(view ->
            {
                screen.setText(screen.getText().toString() + 3);
                operatorSwitch.set(false);
                dotSwitch.set(false);
            });

            four = (Button) findViewById(R.id.four);
            four.setOnClickListener(view ->
            {
                screen.setText(screen.getText().toString() + 4);
                operatorSwitch.set(false);
                dotSwitch.set(false);
            });

            five = (Button) findViewById(R.id.five);
            five.setOnClickListener(view ->
            {
                screen.setText(screen.getText().toString() + 5);
                operatorSwitch.set(false);
                dotSwitch.set(false);
            });

            six = (Button) findViewById(R.id.six);
            six.setOnClickListener(view ->
            {
                screen.setText(screen.getText().toString() + 6);
                operatorSwitch.set(false);
                dotSwitch.set(false);
            });

            seven = (Button) findViewById(R.id.seven);
            seven.setOnClickListener(view ->
            {
                screen.setText(screen.getText().toString() + 7);
                operatorSwitch.set(false);
                dotSwitch.set(false);
            });

            eight = (Button) findViewById(R.id.eight);
            eight.setOnClickListener(view ->
            {
                screen.setText(screen.getText().toString() + 8);
                operatorSwitch.set(false);
                dotSwitch.set(false);
            });

            nine = (Button) findViewById(R.id.nine);
            nine.setOnClickListener(view ->
            {
                screen.setText(screen.getText().toString() + 9);
                operatorSwitch.set(false);
                dotSwitch.set(false);
            });
        }
        catch(Exception e){};
    }
}