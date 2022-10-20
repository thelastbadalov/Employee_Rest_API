package com.example.employeerest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
private String name;
private String surname;
private int age;
private double salary;
}
