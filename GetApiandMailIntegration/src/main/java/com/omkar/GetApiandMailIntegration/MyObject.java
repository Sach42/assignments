package com.omkar.GetApiandMailIntegration;

import org.springframework.stereotype.Component;


public class MyObject {

    private String name;
    private int age;


    public MyObject(String name, int age) {
        this.name = name;
        this.age = age;
    }



    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

