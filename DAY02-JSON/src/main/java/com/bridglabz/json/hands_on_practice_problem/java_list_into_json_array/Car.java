package com.bridglabz.json.hands_on_practice_problem.java_list_into_json_array;
public class Car {
    public String brand;
    public String carName;
    public String model;
    Car(String brand,String name,String model){
        this.brand=brand;
        this.carName=name;
        this.model=model;
    }
    public String getBrand(){
        return brand;
    }
    public String getCarName(){
        return carName;
    }
    public String getModel(){
        return model;
    }
}
