package com.example.bridgelabz.csvdatahandling.advance_problem.merge_two_csv_files;

public class Student {
    public String name;
    public int age;
    public int id;
    public double marks;
    public String grade;
    Student(int id,String name,int age,double marks,String grade){
        this.id=id;
        this.age=age;
        this.name=name;
        this.marks=marks;
        this.grade=grade;
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
    public String getGrade() {
        return grade;
    }

    // Override toString() to print student details
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %d, Marks: %.2f,Grade:%s", id, name, age, marks,grade);
    }
}
