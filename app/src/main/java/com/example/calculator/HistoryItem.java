package com.example.calculator;

import android.widget.TextView;

public class HistoryItem {

    private String action;
    private String result;

    public String getAction() {
        return action;
    }

    public void setAction(Double getX, String act, Double getY, String func, boolean isX) {
        String x = String.valueOf(getX);
        String y = String.valueOf(getY);

        if((getX*10)%10 == 0)x = x.substring(0, x.length()-2);
        if((getY*10)%10 == 0)y = y.substring(0, y.length()-2);

        if(!func.equals("-")){
            if(isX){
                if(getY == 0){ action = func + " = ";
                }else{ action = func + act + y + " = "; }
            }else{
                if(getX == 0){ action = func + " = ";
                }else{ action = x + act + func + " = "; }
            }
        }else{ action = x + act + y + " = "; }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        if(result.length()>10){
            result = result.substring(0, 9);
        }
        this.result = result;
    }
}
