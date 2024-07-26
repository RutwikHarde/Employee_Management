package com.EmployeeManagement.emp.Service;

import com.EmployeeManagement.emp.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmpService {
    Employee saveEmployee(Employee employee);
    Optional<Employee> getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    void deleteEmployee(Long id);
    Employee updateEmployee(Long id, Employee employee);
}
