package com.example.employeerest.service;

import com.example.employeerest.dto.EmployeeDto;
import com.example.employeerest.response.EmployeeResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeResponse getAllEmployees();
    EmployeeDto getEmployeeById(long id);
    EmployeeResponse getEmployeeByNameAndSurname(String name,String surname);
    void insert(EmployeeDto employeeDto);
    void delete(long id);

    void update(EmployeeDto employeeDto,long id);

    void updateSome(EmployeeDto employeeDto, long id);
}
