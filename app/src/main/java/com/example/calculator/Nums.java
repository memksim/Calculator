package com.example.calculator;

import java.lang.Math;

public class Nums{
    private int plus, subtraction, multiplication, division, xInY ,sin;
    private double x = 0;
    private double y = 0;
    private String str;
    private Integer xInt, yInt;
    private int n = 1;
    private boolean isAct = false;
    private int counter = 0;

    //для запятой
    private double z;
    private boolean isCom = false;
    private int last = 0;

    //для отображения функций в истории
    private String function = "-";
    private boolean isX = true;

    public String numButton(final boolean isAct, int num, final boolean isCom) {
        if (isAct) {
            setY(10 * getY() + num);
            str = toInt(getAct());
        } else {
            setX(10 * getX() + num);
            str = toInt(getAct());
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

    public String print(){
        return toInt(getAct());
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
        HistoryItem historyItem = new HistoryItem();

        if(isCom){
            if (isAct){
                setY(getZ());
            }else
                setX(getZ());
        }

        if(getPlus() == 1){
            historyItem.setAction(getX(), "+", getY(), function, isX);
            setX(getX() + getY());
        }
        if(getSubtraction() == 1){
            historyItem.setAction(getX(), "-", getY(), function, isX);
            setX(getX() - getY());
        }
        if(getMultiplication() == 1){
            if(!function.equals("-")){
                historyItem.setAction(getX(), "*", getY(), function, isX);
            }else {
                historyItem.setAction(getX(), "*", getY(), function, isX);            }
            setX(getX() * getY());
        }
        if(getDivision() == 1){
            if(!function.equals("-")){
                historyItem.setAction(getX(), "/", getY(), function, isX);
            }else {
                historyItem.setAction(getX(), "/", getY(), function, isX);            }
            setX(getX() / getY());
        }
        if(getxInY() == 1){
            if(!function.equals("-")){
                historyItem.setAction(getX(), "^", getY(), function, isX);
            }else {
                historyItem.setAction(getX(), "^", getY(), function, isX);            }
            setX(Math.pow(getX(), getY()));
        }

        //эта проверка нужна потому что присваивание action происходит только в операциях,
        //но если операции нет то и нет присваивания
        if(getPlus() == 0 && getSubtraction() == 0 && getMultiplication() == 0 && getDivision() == 0 && getxInY() == 0){
            historyItem.setAction(getX(), "", getY(), function, isX);
        }

        function = "-";
        isX = true;
        setCom(false);
        setAct(false);
        setY(0);
        n = 1;

        str = toInt(getAct());

        historyItem.setResult(String.valueOf(getX()));
        Operations.get().setItem(historyItem);
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
        }else{
            setX(getX() / 100.0);
        }

        str = toInt(getAct());
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
        }else{
            setX(-1 * getX());
        }
        str = toInt(getAct());
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
            str = toInt(getAct());
        }else{
            setX(1/getX());
            str = toInt(getAct());
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
            str = toInt(getAct());
        }else{
            setX(getX()*getX());
            str = toInt(getAct());
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
            str = toInt(getAct());
        }else{
            setX(Math.sqrt(getX()));
            str = toInt(getAct());
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
        n = 1;
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
            function = "fact(" + getY() + ")";
            for(int i = 2; i < getY() + 1; i++){
                fact *= i;
            }
            setY(fact);
            isX = false;
        }else{
            function = "fact(" + getX() + ")";
            for(int i = 2; i < getX() + 1; i++){
                fact *= i;
            }
            setX(fact);
            isX = true;
        }
        str = toInt(getAct());
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
            function = "sin(" + getY() + ")";
            setY(Math.sin(Math.toRadians(getY())));
            isX = false;
        }else{
            function = "sin(" + getX() + ")";
            setX(Math.sin(Math.toRadians(getX())));
            isX = true;
        }
        str = toInt(getAct());
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
            function = "cos(" + getY() + ")";
            setY(Math.cos(Math.toRadians(getY())));
            isX = false;
        }else{
            function = "cos(" + getX() + ")";
            setX(Math.cos(Math.toRadians(getX())));
            isX = true;
        }
        str = toInt(getAct());
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
            function = "tan(" + getY() + ")";
            setY(Math.tan(Math.toRadians(getY())));
            isX = false;
        }else{
            function = "tan(" + getX() + ")";
            setX(Math.tan(Math.toRadians(getX())));
            isX = true;
        }
        str = toInt(getAct());
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
            function = "cot(" + getY() + ")";
            setY(1/Math.tan(Math.toRadians(getY())));
            isX = false;
        }else{
            function = "cot(" + getX() + ")";
            setX(1/Math.tan(Math.toRadians(getX())));
            isX = true;
        }
        str = toInt(getAct());
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

    private String toInt(boolean isAct){

        if(isAct){
            for(double i = 1; i < 8; i++){
                if((getY() * Math.pow(10, i)) % 10 != 0){
                    str = String.valueOf(getY());
                    if(str.length() > 10)str = str.substring(0, 10);
                    return str;
                }
            }
            yInt = (int) getY();
            str = Integer.toString(yInt);
        }else{
            for(double i = 1; i < 8; i++){
                if((getX() * Math.pow(10, i)) % 10 != 0){
                    str = String.valueOf(getX());
                    if(str.length() > 10)str = str.substring(0, 10);
                    return str;
                }
            }
            xInt = (int) getX();
            str = Integer.toString(xInt);
        }

        return str;
    }

}


