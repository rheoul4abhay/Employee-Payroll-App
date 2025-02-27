package com.spring.employee_payroll_app.controllers;

import com.spring.employee_payroll_app.dto.EmployeeDTO;
import com.spring.employee_payroll_app.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee-payroll-service")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public EmployeeDTO registerEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Received request to register a new employee: {}", employeeDTO);
        EmployeeDTO savedEmployee = employeeService.registerEmployee(employeeDTO);
        log.info("Employee registered successfully: {}", savedEmployee);
        return savedEmployee;
    }

    @GetMapping("/records")
    public List<EmployeeDTO> fetchAllPayrollRecords() {
        List<EmployeeDTO> employeeList = employeeService.fetchAllPayrollRecords();
        if (employeeList.isEmpty()) {
            log.warn("No payroll records found.");
        } else {
            log.info("All payroll records retrieved successfully.");
        }
        return employeeList;
    }

    @GetMapping("/record/{name}")
    public EmployeeDTO fetchEmployeePayrollByName(@PathVariable String name) {
        EmployeeDTO employee = employeeService.fetchPayrollRecordByName(name);
        if (employee != null) {
            log.info("Payroll record for Employee {} retrieved successfully.", name);
        } else {
            log.warn("No payroll record found for Employee {}", name);
        }
        return employee;
    }

    @PutMapping("/update/{name}")
    public EmployeeDTO updateEmployeePayrollByName(@PathVariable String name, @Valid @RequestBody EmployeeDTO updatedEmployeeDTO) {
        EmployeeDTO updatedRecord = employeeService.updatePayrollRecordByName(name, updatedEmployeeDTO);
        if (updatedRecord != null) {
            log.info("Payroll record for Employee {} updated successfully.", name);
        } else {
            log.warn("No payroll record found for Employee {}", name);
        }
        return updatedRecord;
    }

    @DeleteMapping("/remove/{name}")
    public String removeEmployeeFromPayroll(@PathVariable String name) {
        boolean isDeleted = employeeService.removeEmployeeFromPayroll(name);
        if (isDeleted) {
            log.info("Employee {} removed from payroll successfully!", name);
            return "Employee removed from payroll successfully.";
        } else {
            log.warn("No payroll record found for Employee {}", name);
            return "Employee '" + name + "' not found in payroll records.";
        }
    }

    @DeleteMapping("/clear")
    public String clearPayrollRecords() {
        boolean isDeleted = employeeService.clearPayrollRecords();
        if (isDeleted) {
            log.info("All payroll records cleared successfully!");
            return "All payroll records have been cleared.";
        } else {
            log.warn("No payroll records found to clear.");
            return "No payroll records to clear.";
        }
    }
}
