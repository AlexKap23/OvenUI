package com.example.alex.ovenui;

/**
 * Created by alex on 16/10/2017.
 */

public class FoodParameters {

    String name;
    int temp;
    int time;
    String type;

    public FoodParameters(String name,int temp,int time,String type){
        this.name = name;
        this.time = time;
        this.temp = temp;
        this.type = type;
    }

    //setters and getters
    private void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    private void setTemp(int temp){
        this.temp = temp;
    }
    public int getTemp(){
        return temp;
    }

    private void setTime(int time){
        this.time = time;
    }
    public int getTime(){
        return time;
    }

    private void setType(String type){
        this.type = type;
    }
    private String getType(){
        return type;
    }
}
