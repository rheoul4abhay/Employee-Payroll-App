package com.spring.employee_payroll_app.controllers;

import com.spring.employee_payroll_app.models.Employee;
import com.spring.employee_payroll_app.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.employee_payroll_app.models.Employee;
import java.util.ArrayList;
import java.util.List;

@Slf4j //for logging
@RestController
@RequestMapping("/employee-payroll-service")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;
    //Constructor based injection (Better for testing purpose)
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        log.info("Received request to add a new employee: {}", employee);
        log.info("Employee added successfully: {}", employee);
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/show/all")
    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        if(employeeList.isEmpty()){
            log.warn("No employee found to show.");
        }
        else {
            log.info("All employees shown successfully.");
        }
        return employeeService.getAllEmployees();
    }

    @GetMapping("/show/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        if(employeeService.getEmployeeById(id) != null){
            log.info("Employee with ID {} fetched successfully", id);
        }
        else{
            log.warn("No employee found with ID {}", id);
        }
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployeeById(@PathVariable long id, @RequestBody Employee updatedEmployee){
        if(employeeService.updateEmployeeById(id, updatedEmployee) != null){
            log.info("Employee with ID {} updated successfully!", id);
        }
        else {
            log.warn("No employee found with ID {}", id);
        }
        return employeeService.updateEmployeeById(id, updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable long id){
        boolean isDeleted = employeeService.deleteEmployeeById(id);
        if(isDeleted){
            log.info("Employee with ID {} deleted successfully!", id);
        }
        else{
            log.warn("No employee found with ID {}", id);
        }
        return isDeleted ? "Employee deleted successfully" : "Employee with ID '" + id + "' not found";
    }

    @DeleteMapping("/delete/all")
    public String deleteAllEmployees(){
        boolean isDeleted = employeeService.deleteAllEmployees();
        if(isDeleted){
            log.info("All employees deleted successfully!");
        }
        else{
            log.warn("No employee in record to delete!");
        }
        return isDeleted ? "All Employees deleted successfully" : "No employee to delete";
    }
}