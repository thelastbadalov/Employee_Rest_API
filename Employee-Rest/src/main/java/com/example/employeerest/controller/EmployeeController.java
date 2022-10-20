package com.example.employeerest.controller;

import com.example.employeerest.dto.EmployeeDto;
import com.example.employeerest.response.EmployeeResponse;
import com.example.employeerest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public EmployeeResponse getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/search")
    public EmployeeResponse getEmployeeByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.getEmployeeByNameAndSurname(name, surname);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
public  void insert(@RequestBody EmployeeDto employeeDto){
        employeeService.insert(employeeDto);
    }


   @PutMapping("/update/{id}")
   public void update(@RequestBody EmployeeDto employeeDto,@PathVariable long id){
        employeeService.update(employeeDto,id);
   }
@PatchMapping("/{id}")
public void updateSome(@RequestBody EmployeeDto employeeDto,@PathVariable("id") long id) {
    employeeService.updateSome(employeeDto, id);
}
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        employeeService.delete(id);
    }


}

