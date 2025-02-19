package com.bridglabz.json.hands_on_practice_problem.json_to_xml;
import java.util.*;
public class Student {
    public String name;
    public String email;
    public int age;
    public Address address;
    public List<String> hobbies;

    // Constructor, getters, and setters
    public Student(String name, String email, int age, Address address, List<String> hobbies) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}


