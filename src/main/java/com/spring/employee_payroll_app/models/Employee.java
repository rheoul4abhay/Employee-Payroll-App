package com.spring.employee_payroll_app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee_payroll")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//  @NotNull
//  @Size(min = 2, message = "Name should be atleast 2 characters long")
//  @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name should contain only alphabets")
    private String name;

//  @NotNull
    private double salary;

    public Employee(){};

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

}