package com.bridglabz.json.hands_on_practice_problem.json_to_xml;
import java.util.*;
public class Address {
    public String city;
    public String country;

    // Constructor, getters, and setters
    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
