package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ButtonData> buttonData;
    String expression = "";
    boolean gotResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeButtonData();
        createMainLayout();
        createPanelDisplay();
        createButtons(); //performs actions based on which type of button is pushed (use lambda vs setonclick)
    }

    private void createMainLayout() {
        GridLayout mainLayout = new GridLayout(this);
        mainLayout.setId(R.id.mainLayout);
        mainLayout.setColumnCount(4);
        mainLayout.setBackgroundColor(getResources().getColor(R.color.bgColor));
        setContentView(mainLayout);
    }

    private void createPanelDisplay() {
        Panel panel = new Panel(this);
        panel.setId(R.id.panelDisplay);
        GridLayout mainLayout = findViewById(R.id.mainLayout);
        mainLayout.addView(panel);
    }

    private void createButtons() {
        GridLayout mainLayout = findViewById(R.id.mainLayout);
        Panel panel = findViewById(R.id.panelDisplay);

        for (ButtonData data: buttonData) {
            if (data.type == ButtonData.ButtonType.INPUT) {
                NumberButton button = new NumberButton(this,
                        data,
                        view -> {
                            if (gotResult) expression = "";
                            expression += data.text;
                            panel.setText(expression);
                        });
                button.setText(data.text);
                mainLayout.addView(button);
            }
            else {
                OperatorButton button = new OperatorButton(this,
                        data,
                        view -> {
                            gotResult = false;

                            if (data.type == ButtonData.ButtonType.OPER) {
                                expression += (" " + data.text + " ");
                                panel.setText(expression);
                            }
                            if (data.type == ButtonData.ButtonType.EVAL) {
                                double solution = Calculator.evaluate(expression);
                                expression = String.valueOf(solution);
                                if (expression == "NaN") {
                                    expression = "";
                                }
                                else gotResult = true;
                                panel.setText(expression);
                            }
                            if (data.type == ButtonData.ButtonType.CLEAR) {
                                expression = "";
                                panel.setText(expression);
                            }
                        });
                mainLayout.addView(button);
                button.setText(data.text);
            }
        }
    }

    private void initializeButtonData() {
        buttonData = new ArrayList<ButtonData>() {
            {
                add(new ButtonData("C", 0, 3, 1, ButtonData.ButtonType.CLEAR));
                add(new ButtonData("7", 1, 0, 1));
                add(new ButtonData("8", 1, 1, 1));
                add(new ButtonData("9", 1, 2, 1));
                add(new ButtonData("/", 1, 3, 1, ButtonData.ButtonType.OPER));
                add(new ButtonData("4", 2, 0, 1));
                add(new ButtonData("5", 2, 1, 1));
                add(new ButtonData("6", 2, 2, 1));
                add(new ButtonData("*", 2, 3, 1, ButtonData.ButtonType.OPER));
                add(new ButtonData("1", 3, 0, 1));
                add(new ButtonData("2", 3, 1, 1));
                add(new ButtonData("3", 3, 2, 1));
                add(new ButtonData("-", 3, 3, 1, ButtonData.ButtonType.OPER));
                add(new ButtonData("0", 4, 0, 2));
                add(new ButtonData(".", 4, 2, 1));
                add(new ButtonData("+", 4, 3, 1, ButtonData.ButtonType.OPER));
                add(new ButtonData("=", 5, 0, 4, ButtonData.ButtonType.EVAL));
            }
        };
    }
}
