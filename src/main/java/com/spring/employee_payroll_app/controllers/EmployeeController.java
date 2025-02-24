package com.spring.employee_payroll_app.controllers;

import com.spring.employee_payroll_app.models.Employee;
import org.springframework.web.bind.annotation.*;
import com.spring.employee_payroll_app.models.Employee;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final List<Employee> employeeList = new ArrayList<>();

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        employeeList.add(employee);
        return employee;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        for(Employee emp: employeeList){
            if(emp.getId() == id){
                return emp;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable long id, @RequestBody Employee updatedEmployee){
        for(Employee emp: employeeList){
            if(emp.getId() == id){
                emp.setName(updatedEmployee.getName());
                emp.setSalary(updatedEmployee.getSalary());
                return emp;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable long id){
        for(Employee emp: employeeList){
            if(emp.getId() == id){
                employeeList.remove(emp);
                return "Employee with ID '" + id + "' removed successfully!";
            }
        }
        return "No employee with ID '" + id + "' found.";
    }
}

