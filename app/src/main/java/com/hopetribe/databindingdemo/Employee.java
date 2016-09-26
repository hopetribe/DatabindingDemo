package com.hopetribe.databindingdemo;

/**
 * Created by DW on 2016/9/23.
 */

public class Employee {
    public final String lastName;
    public final String firstName;
    public final int age;

    public Employee(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
