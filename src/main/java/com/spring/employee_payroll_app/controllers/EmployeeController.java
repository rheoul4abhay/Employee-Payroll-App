package com.spring.employee_payroll_app.controllers;

import com.spring.employee_payroll_app.models.Employee;
import com.spring.employee_payroll_app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.employee_payroll_app.models.Employee;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    //Constructor based injection (Better for testing purpose)
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/show/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/show/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployeeById(@PathVariable long id, @RequestBody Employee updatedEmployee){
        return employeeService.updateEmployeeById(id, updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable long id){
        boolean isDeleted = employeeService.deleteEmployeeById(id);
        return isDeleted ? "Employee deleted successfully" : "Employee with ID '" + id + "' not found";
    }

    @DeleteMapping("/delete/all")
    public String deleteAllEmployees(){
        boolean isDeleted = employeeService.deleteAllEmployees();
        return isDeleted ? "All Employees deleted successfully" : "No employee to delete";
    }
}