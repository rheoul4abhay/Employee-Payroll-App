package com.spring.employee_payroll_app.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Data
@Getter
@Setter
public class EmployeeDTO {

    @NotNull
    @Size(min = 2, message = "Name should be atleast 2 characters long")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name should contain only alphabets")
    private String name;

    @NotNull
    private double salary;

    public EmployeeDTO(){};

    public EmployeeDTO(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    //getter setters for if lombok fails to run(just in case)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
