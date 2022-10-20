package com.example.employeerest.response;

import com.example.employeerest.dto.EmployeeDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
private List<EmployeeDto> employeeDtos;
}
