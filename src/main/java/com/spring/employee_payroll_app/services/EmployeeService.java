package com.spring.employee_payroll_app.services;

import com.spring.employee_payroll_app.models.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(@RequestBody Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(@PathVariable Long id){
        for(Employee emp: employeeList){
            if(emp.getId() == id){
                return emp;
            }
        }
        return null;
    }

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

    public boolean deleteEmployeeById(@PathVariable long id){
        for(Employee emp: employeeList){
            if(emp.getId() == id){
                employeeList.remove(emp);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAllEmployees(){
        if(!employeeList.isEmpty()){
            employeeList.clear();
            return true;
        }
        return false;
    }
}