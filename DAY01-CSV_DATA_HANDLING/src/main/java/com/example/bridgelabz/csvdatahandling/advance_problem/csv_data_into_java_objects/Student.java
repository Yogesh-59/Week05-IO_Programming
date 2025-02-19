package com.example.bridgelabz.csvdatahandling.advance_problem.csv_data_into_java_objects;

public class Student {
    public String name;
    public int age;
    public int id;
    public double marks;
    Student(int id,String name,int age,double marks){
        this.id=id;
        this.age=age;
        this.name=name;
        this.marks=marks;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    // Override toString() to print student details
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %d, Marks: %.2f", id, name, age, marks);
    }
}
