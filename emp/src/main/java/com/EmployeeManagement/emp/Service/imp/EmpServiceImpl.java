package com.EmployeeManagement.emp.Service.imp;

import com.EmployeeManagement.emp.Model.Employee;
import com.EmployeeManagement.emp.Repository.EmpRepo;
import com.EmployeeManagement.emp.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepo empRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return empRepo.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        empRepo.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if (empRepo.existsById(id)) {
            employee.setId(id); // Set the ID of the existing employee
            return empRepo.save(employee);
        }
        return null; // Or throw an exception if the employee is not found
    }

}

