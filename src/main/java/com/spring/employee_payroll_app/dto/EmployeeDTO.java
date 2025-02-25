package com.spring.employee_payroll_app.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDTO {

    private String name;
    private double salary;

    public EmployeeDTO(){};

    public EmployeeDTO(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

}
