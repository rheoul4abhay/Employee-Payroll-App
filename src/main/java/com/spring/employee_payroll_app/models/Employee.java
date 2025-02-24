package com.spring.employee_payroll_app.models;

public class Employee {
    private long id;
    private String name;
    private double salary;

    public Employee(){};

    public Employee(Long id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    //getters and setters
    public long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
}