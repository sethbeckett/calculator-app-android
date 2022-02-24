package com.example.calculator;

public class Calculator {
    public static double evaluate(String expression) {
        String[] tokens = expression.split(" ");

        if (tokens.length == 0) return 0;

        if (tokens.length == 1) {
            try {
                return Double.parseDouble(tokens[0]);
            }
            catch (NumberFormatException e){
                return Double.NaN;
            }
        }

        if (tokens.length == 2) return Double.parseDouble(tokens[0]);

        double currentValue = Double.parseDouble(tokens[0]);
        String operation = tokens[1];
        String mode = "value";

        for (int i = 2; i < tokens.length; i++) {
            if (mode.equals("value")) {
                double foundValue = Double.parseDouble(tokens[i]);

                if (operation.equals("+")) currentValue = currentValue + foundValue;

                if (operation.equals("-")) currentValue = currentValue - foundValue;

                if (operation.equals("/")) currentValue = currentValue / foundValue;

                if (operation.equals("*")) currentValue = currentValue * foundValue;

                mode = "operator";
            } else {
                operation = tokens[i];
                mode = "value";
            }
        }

        return currentValue;
    }
}
