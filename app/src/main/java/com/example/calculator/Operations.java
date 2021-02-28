package com.example.calculator;

import android.graphics.Path;

import java.util.ArrayList;
import java.util.List;

public  class Operations {

    private static Operations operations;
    private List<HistoryItem> operationsList;

    private Operations(){
        operationsList = new ArrayList<>();
        /*for(int i = 0; i < 10; i++){
            HistoryItem historyItem = new HistoryItem();
            historyItem.setAction(String.valueOf(i), "+", String.valueOf(i+1));
            historyItem.setResult(String.valueOf(i+2));
            operationsList.add(historyItem);
        }*/
    }

    public static Operations get(){
        if(operations == null){
            operations = new Operations();
        }
        return operations;
    }

    public List<HistoryItem> getOperations(){
        return operationsList;
    }

    public void setItem(HistoryItem item){
        operationsList.add(item);
    }


}

