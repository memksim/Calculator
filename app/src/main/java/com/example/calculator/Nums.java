package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Nums extends Operations {
    private int plus, subtraction, multiplication, division;
    private double x, y;
    private String str;
    private Integer xInt, yInt;
    private boolean isAct = false;
    private int counter = 0;


    public String numButton(final boolean isAct, int num) {
        if (isAct) {
            setY(10 * getY() + num);
            if ((getY() * 10) % 10 == 0) {
                yInt = (int) getY();
                str = Integer.toString(yInt);
            } else {
                str = Double.toString(getY());
            }
        } else {
            setX(10 * getX() + num);
            if ((getX() * 10) % 10 == 0) {
                xInt = (int) getX();
                str = Integer.toString(xInt);
            } else {
                str = Double.toString(getX());
            }

        }
        return str;
    }

    public void operationPlus(){
        setCounter(0);
        setAct(true);
        setPlus(1);
        setSubtraction(0);
        setMultiplication(0);
        setDivision(0);
    }
    public void operationSubtraction(){
        setCounter(0);
        setAct(true);
        setPlus(0);
        setSubtraction(1);
        setMultiplication(0);
        setDivision(0);
    }
    public void operationMultiplication(){
        setCounter(0);
        setAct(true);
        setPlus(0);
        setSubtraction(0);
        setMultiplication(1);
        setDivision(0);
    }
    public void operationDivision(){
        setCounter(0);
        setAct(true);
        setPlus(0);
        setSubtraction(0);
        setMultiplication(0);
        setDivision(1);
    }
    public String operationClearLastSymbol(boolean isAct){
        if(isAct){
            setY(getY() - (getY() % 10.0));
            yInt = (int) getY();
            str = Integer.toString(yInt);
        }else{
            setX((getX() - (getX() % 10.0))/10);
            xInt = (int) getX();
            str = Integer.toString(xInt);
        }
        setCounter(str.length());
        return str;
    }
    public String operationPercent(boolean isAct){
        if(isAct){
            setY(getX() * (getY() / 100.0));
            str = Double.toString(getY());
        }else{
            setX(getX() / 100.0);
            str = Double.toString(getX());
        }
        setCounter(str.length());
        if(getCounter() > 9){
            return str.substring(0, 8);
        }
        return str;
    }
    public String operationPlusMinus(boolean isAct){
        if(isAct){
            setY(-1 * getY());
            if((getX()*10) % 10 == 0){
                yInt = (int) getY();
                str = Integer.toString(yInt);
            }else{
                str = Double.toString(getY());
            }
        }else{
            setX(-1 * getX());
            if((getX()*10) % 10 == 0){
                xInt = (int) getX();
                str = Integer.toString(xInt);
            }else{
                str = Double.toString(getX());
            }
        }
        setCounter(str.length());
        return str;
    }
    public String operationClearAll(){
        setX(0);
        setY(0);
        setCounter(0);
        return "0";
    }
    public String operationEqual(){
        if(getPlus() == 1)setX(getX() + getY());
        if(getSubtraction() == 1)setX(getX() - getY());
        if(getMultiplication() == 1)setX(getX() * getY());
        if(getDivision() == 1)setX(getX() / getY());

        if((getX()*10) % 10 == 0){
            xInt = (int) getX();
            str = Integer.toString(xInt);
        }else{
            str = Double.toString(getX());
        }

        setAct(false);
        setY(0);

        setCounter(str.length());
        if(getCounter() > 9){
            return str.substring(0, 8);
        }
        return str;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public int getPlus () {
        return plus;
    }
    public void setPlus ( int plus){
        this.plus = plus;
    }
    public int getSubtraction () {
        return subtraction;
    }
    public void setSubtraction ( int subtraction){
        this.subtraction = subtraction;
    }
    public int getMultiplication () {
        return multiplication;
    }
    public void setMultiplication ( int multiplication){
        this.multiplication = multiplication;
    }
    public int getDivision () {
        return division;
    }
    public void setDivision ( int division){
        this.division = division;
    }
    public boolean getAct() {
        return isAct;
    }
    public void setAct(boolean act) {
        isAct = act;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
}


