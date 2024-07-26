package com.EmployeeManagement.emp.Repository;

import com.EmployeeManagement.emp.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository< Employee,Long> {
}
