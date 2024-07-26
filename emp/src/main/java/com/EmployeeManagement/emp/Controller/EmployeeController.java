package com.EmployeeManagement.emp.Controller;

import com.EmployeeManagement.emp.Dto.Request.EmployeeRequest;
import com.EmployeeManagement.emp.Dto.Response.EmployeeResponse;
import com.EmployeeManagement.emp.Model.Employee;
import com.EmployeeManagement.emp.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest req) {
        Employee employee = new Employee();
        employee.setName(req.getName());
        employee.setPosition(req.getPosition());
        employee.setSalary(req.getSalary());

        Employee savedEmployee = empService.saveEmployee(employee);
        EmployeeResponse response = new EmployeeResponse(savedEmployee.getId(), savedEmployee.getName(), savedEmployee.getPosition(), savedEmployee.getSalary());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Optional<Employee> employee = empService.getEmployeeById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        Optional<Employee> employee = empService.getEmployeeById(id);
        if (employee.isPresent()) {
            empService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = empService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequest req) {
        Employee employee = new Employee();
        employee.setName(req.getName());
        employee.setPosition(req.getPosition());
        employee.setSalary(req.getSalary());

        Employee updatedEmployee = empService.updateEmployee(id, employee);
        if (updatedEmployee != null) {
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
