package com.spring.employee_payroll_app.exception;

import com.spring.employee_payroll_app.dto.EmployeeDTO;

public class EmployeePayrollNotFoundException extends RuntimeException {

    public EmployeePayrollNotFoundException(String name){
        super("Unable to find employee payroll with name " + name);
    }

    public EmployeePayrollNotFoundException(Long id){
        super("Unable to find employee payroll with ID " + id);
    }

    public EmployeePayrollNotFoundException(EmployeeDTO employeeDTO){
        super("Unable to find employee payroll with name " + employeeDTO.getName());
    }
}
