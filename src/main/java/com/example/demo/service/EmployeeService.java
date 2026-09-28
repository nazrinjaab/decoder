package com.example.demo.service;


import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1L, "Ali", "IT"));
        employees.add(new Employee(2L, "Leyla", "HR"));
        employees.add(new Employee(3L, "Nazrin", "IT"));
        employees.add(new Employee(4L, "Aysel", "Finance"));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public List<Employee> getEmployeesByDepartment(String department) {

        if (department == null) {
            return employees;
        }

        List<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                result.add(employee);
            }
        }

        return result;
    }
}
