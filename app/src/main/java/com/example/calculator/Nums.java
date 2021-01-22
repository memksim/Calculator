package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;

public class Nums{
    private int plus, subtraction, multiplication, division, xInY;
    private double x = 0;
    private double y = 0;
    private String str;
    private Integer xInt, yInt;
    private int num = 0;
    private boolean isAct = false;
    private int counter = 0;


    //для запятой
    private double z;
    private boolean isCom = false;
    int last = 0;

    public String numButton(final boolean isAct, int num, final boolean isCom) {
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

        if(isCom){
            if(isAct){
                last = (int) getY() % 10;
                setZ(getZ() + (last / Math.pow(10, str.length())));
                str = Double.toString(getZ());
            }else {
                last = (int) getX() % 10;
                setZ(getZ() + (last / Math.pow(10, str.length())));
                str = Double.toString(getZ());
            }
        }

        return str;
    }

    public String print(boolean isAct){
        if(isAct){
            if((getY() * 10) % 10 == 0){
                yInt = (int) getY();
                str = Integer.toString(yInt);
            }else{
                str = Double.toString(getY());
            }
        }else{
            if((getY() * 10) % 10 == 0){
                xInt = (int) getX();
                str = Integer.toString(xInt);
            }else{
                str = Double.toString(getX());
            }
        }
        return str;
    }

    public void operationPlus(){
        if(isCom){
            setX(getZ());
        }
        setCounter(0);
        setAct(true);
        setPlus(1);
        setSubtraction(0);
        setMultiplication(0);
        setDivision(0);
        setxInY(0);
        setCom(false);
    }
    public void operationSubtraction(){
        if(isCom){
            setX(getZ());
        }
        setCounter(0);
        setAct(true);
        setPlus(0);
        setSubtraction(1);
        setMultiplication(0);
        setDivision(0);
        setxInY(0);
        setCom(false);
    }
    public void operationMultiplication(){
        if(isCom){
            setX(getZ());
        }
        setCounter(0);
        setAct(true);
        setPlus(0);
        setSubtraction(0);
        setMultiplication(1);
        setDivision(0);
        setxInY(0);
        setCom(false);
    }
    public void operationDivision(){
        if(isCom){
            setX(getZ());
        }
        setCounter(0);
        setAct(true);
        setPlus(0);
        setSubtraction(0);
        setMultiplication(0);
        setDivision(1);
        setxInY(0);
        setCom(false);
    }

    public String operationEqual(){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }
        if(getPlus() == 1)setX(getX() + getY());
        if(getSubtraction() == 1)setX(getX() - getY());
        if(getMultiplication() == 1)setX(getX() * getY());
        if(getDivision() == 1)setX(getX() / getY());
        if(getxInY() == 1)setX(Math.pow(getX(), getY()));

        if((getX()*10) % 10 == 0){
            xInt = (int) getX();
            str = Integer.toString(xInt);
        }else{
            str = Double.toString(getX());
        }

        setCom(false);
        setAct(false);
        setY(0);

        setCounter(str.length());
        if(getCounter() > 10 ){
            str = str.substring(0,10);
        }
        return str;
    }

    public String operationPercent(boolean isAct){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }

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
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }

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
    public String operationCoup(boolean isAct){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }

        if (isAct){
            setY(1/getY());
            if((getY()*10)%10 == 0){
                yInt = (int) getY();
                str = Integer.toString(yInt);
            }else{
                str = Double.toString(getY());
            }
        }else{
            setX(1/getX());
            if((getX()*10)%10 == 0){
                xInt = (int) getX();
                str = Integer.toString(xInt);
            }else{
                str = Double.toString(getX());
            }
        }

        setCounter(str.length());
        if(getCounter()>9){
            setCounter(6);
            str = str.substring(0,7);
            if(isAct){
                setY(Double.valueOf(str));
            }else{
                setX(Double.valueOf(str));
            }
        }
        return str;
    }
    public String operationSquare(boolean isAct){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }

        if(isAct){
            setY(getY()*getY());
            if((getY()*10)%10 == 0){
                yInt = (int) getY();
                str = Integer.toString(yInt);
            }else{
                str = Double.toString(getY());
            }
        }else{
            setX(getX()*getX());
            if((getX()*10)%10 == 0){
                xInt = (int) getX();
                str = Integer.toString(xInt);
            }else{
                str = Double.toString(getX());
            }
        }

        setCounter(str.length());
        if(getCounter()>9){
            setCounter(6);
            str = str.substring(0,7);
            if(isAct){
                setY(Double.valueOf(str));
            }else{
                setX(Double.valueOf(str));
            }
        }


        return str;
    }
    public String operationSqrt(boolean isAct){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }

        if(isAct){
            setY(Math.sqrt(getY()));
            if((getY()*10)%10 == 0){
                yInt = (int) getY();
                str = Integer.toString(yInt);
            }else{
                str = Double.toString(getY());
            }
        }else{
            setX(Math.sqrt(getX()));
            if((getX()*10) % 10 == 0){
                xInt = (int) getX();
                str = Integer.toString(xInt);
            }else{
                str = Double.toString(getX());
            }
        }

        setCounter(str.length());
        if(getCounter()>9){
            setCounter(6);
            str = str.substring(0,7);
            if(isAct){
                setY(Double.valueOf(str));
            }else{
                setX(Double.valueOf(str));
            }
        }

        return str;
    }

    public String operationClearXorY(boolean isAct){
        if(isAct){
            setY(0);
            yInt = (int) getY();
            str = Integer.toString(yInt);
        }else{
            setX(0);
            xInt = (int) getX();
            str = Integer.toString(xInt);
        }

        return str;
    }
    public String operationClearAll(){
        setX(0);
        setY(0);
        setCounter(0);
        setxInY(0);
        setCom(false);
        setPlus(0);
        setSubtraction(0);
        setMultiplication(0);
        setDivision(0);
        setZ(0);
        setAct(false);
        return "0";
    }
    public String operationClearLastSymbol(boolean isAct){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }
        if(isAct){

            str = Double.toString(getY()).substring(0, str.length() - 1);
            setY(Double.valueOf(str));
            if ((getY() * 10) % 10 == 0) {
                yInt = (int) getY();
                str = Integer.toString(yInt);
            } else {
                str = Double.toString(getY());
            }

        }else{
            str = Double.toString(getX()).substring(0, str.length() - 1);
            setX(Double.valueOf(str));
            if ((getX() * 10) % 10 == 0) {
                xInt = (int) getX();
                str = Integer.toString(xInt);
            } else {
                str = Double.toString(getX());
            }


        }

        setCounter(str.length());
        return str;
    }

    public String operationFact(boolean isAct){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }
        double fact = 1;
        if(isAct){
            for(int i = 2; i < getY() + 1; i++){
                fact *= i;
            }

            setY(fact);

            if((fact * 10)%10 == 0){
                yInt = (int) getY();
                str = Integer.toString(yInt);
            }else
                str = Double.toString(getY());
        }else{
            for(int i = 2; i < getX() + 1; i++){
                fact *= i;
            }

            setX(fact);

            if((fact * 10)%10 == 0){
                xInt = (int) getX();
                str = Integer.toString(xInt);
            }else
                str = Double.toString(getX());
        }
        return str;
    }
    public String operationXInY(){
        if(isCom){
            setX(getZ());
        }
        setCounter(0);
        setAct(true);
        setPlus(0);
        setSubtraction(0);
        setMultiplication(0);
        setDivision(0);
        setxInY(1);
        setCom(false);

        return str;
    }

    public String operationSin(boolean isAct){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }
        if(isAct) {
            setY(Math.sin(Math.toRadians(getY())));
            str = Double.toString(getY());
        }else{
            setX(Math.sin(Math.toRadians(getX())));
            str = Double.toString(getX());
        }

        return str;
    }
    public String operationCos(boolean isAct){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }
        if(isAct) {
            setY(Math.cos(Math.toRadians(getY())));
            str = Double.toString(getY());
        }else{
            setX(Math.cos(Math.toRadians(getX())));
            str = Double.toString(getX());
        }
        return str;
    }
    public String operationTan(boolean isAct){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }
        if(isAct) {
            setY(Math.tan(Math.toRadians(getY())));
            str = Double.toString(getY());
        }else{
            setX(Math.tan(Math.toRadians(getX())));
            str = Double.toString(getX());
        }
        return str;
    }
    public String operationCot(boolean isAct){
        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }
        if(isAct) {
            setY(1/Math.tan(Math.toRadians(getY())));
            str = Double.toString(getY());
        }else{
            setX(1/Math.tan(Math.toRadians(getX())));
            str = Double.toString(getX());
        }
        return str;
    }

    public void operationComma(boolean isAct){
        if(isAct){
            setZ(getY());
            setY(0);
        }else{
            setZ(getX());
            setX(0);
        }
        setCom(true);
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
    public int getxInY() {
        return xInY;
    }
    public void setxInY(int xInY) {
        this.xInY = xInY;
    }
    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }
    public boolean isCom() {
        return isCom;
    }
    public void setCom(boolean com) {
        isCom = com;
    }
}


