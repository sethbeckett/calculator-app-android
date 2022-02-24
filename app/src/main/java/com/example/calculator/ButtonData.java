package com.example.calculator;

public class ButtonData {
    public String text;
    public int row;
    public int col;
    public int colSpan;
    public ButtonType type;

    public enum ButtonType {
        INPUT,
        CLEAR,
        EVAL,
        OPER
    }

    public ButtonData(String text, int row, int col, int colSpan, ButtonType type) {
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
        this.type = type;
    }

    public ButtonData(String text, int row, int col, int colSpan) {
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
        this.type = ButtonType.INPUT;
    }
}
