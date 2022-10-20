package com.example.employeerest.service.impl;

import com.example.employeerest.dto.EmployeeDto;
import com.example.employeerest.exception.CustomRestException;
import com.example.employeerest.exception.enums.ErrorCodeEnum;
import com.example.employeerest.model.Employee;
import com.example.employeerest.repository.EmployeeRepository;
import com.example.employeerest.response.EmployeeResponse;
import com.example.employeerest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public EmployeeResponse getAllEmployees() {
       List<EmployeeDto> employeeDtoList= employeeRepository.findAll().stream().map(employee -> convertToDto(employee)).collect(Collectors.toList());
    return EmployeeResponse.builder().employeeDtos(employeeDtoList).build();
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
return employeeRepository.
        findById(id).
        map(employee -> convertToDto(employee)).
        orElseThrow(()->new CustomRestException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getMessage()));

    }

    @Override
    public EmployeeResponse getEmployeeByNameAndSurname(String name, String surname) {
        List<EmployeeDto> employeeDtoList= employeeRepository.getEmployeeByNameAndSurname(name,surname).stream().map(employee -> convertToDto(employee)).collect(Collectors.toList());
return makeEmployeeResponse(employeeDtoList);
    }

    @Override
    public void insert(EmployeeDto employeeDto) {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeRepository.save(employee);
    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(EmployeeDto employeeDto, long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new CustomRestException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getMessage()));
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setAge(employeeDto.getAge());
        employee.setSalary(employeeDto.getSalary());
employeeRepository.save(employee);

    }

    @Override
    public void updateSome(EmployeeDto employeeDto, long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new CustomRestException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getMessage()));
if(employeeDto.getName()!=null)
    employee.setName(employeeDto.getName());
if(employeeDto.getSurname()!=null)
    employee.setSurname(employeeDto.getSurname());
if(employeeDto.getAge()>0)
employee.setAge(employeeDto.getAge());
if(employee.getSalary()>0)
    employee.setSalary(employeeDto.getSalary());

employeeRepository.save(employee);

    }

    private EmployeeDto convertToDto(Employee employee) {
  EmployeeDto employeeDto=new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        return employeeDto;
    }

private EmployeeResponse makeEmployeeResponse(List<EmployeeDto> employeeDtoList){
    return EmployeeResponse.builder().employeeDtos(employeeDtoList).build();
}
}
