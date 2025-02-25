package com.spring.employee_payroll_app.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EmployeeDTO {

    private String name;
    private double salary;

    public EmployeeDTO(){};

    public EmployeeDTO(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    //getters and setters

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
