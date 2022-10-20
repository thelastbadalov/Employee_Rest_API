package com.example.employeerest.repository;

import com.example.employeerest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> getEmployeeByNameAndSurname(String name,String surname);
}
