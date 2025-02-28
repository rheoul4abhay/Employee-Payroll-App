package com.spring.employee_payroll_app.services;

import com.spring.employee_payroll_app.dto.EmployeeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<EmployeeDTO> employeeList = new ArrayList<>();

    public EmployeeDTO registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeList.add(employeeDTO);
        return employeeDTO;
    }

    public List<EmployeeDTO> fetchAllPayrollRecords() {
        return new ArrayList<>(employeeList);
    }

    public EmployeeDTO fetchPayrollRecordByName(@PathVariable String name) {
        for (EmployeeDTO emp : employeeList) {
            if (emp.getName().equalsIgnoreCase(name)) {
                return emp;
            }
        }
        return null;
    }

    public EmployeeDTO updatePayrollRecordByName(@PathVariable String name, @RequestBody EmployeeDTO updatedEmployeeDTO) {
        for (EmployeeDTO emp : employeeList) {
            if (emp.getName().equalsIgnoreCase(name)) {
                emp.setName(updatedEmployeeDTO.getName());
                emp.setSalary(updatedEmployeeDTO.getSalary());
                return emp;
            }
        }
        return null;
    }

    public boolean removeEmployeeFromPayroll(@PathVariable String name) {
        for (EmployeeDTO emp : employeeList) {
            if (emp.getName().equalsIgnoreCase(name)) {
                employeeList.remove(emp);
                return true;
            }
        }
        return false;
    }

    public boolean clearPayrollRecords() {
        if (!employeeList.isEmpty()) {
            employeeList.clear();
            return true;
        }
        return false;
    }
}
