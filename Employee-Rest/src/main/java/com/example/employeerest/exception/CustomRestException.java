package com.example.employeerest.exception;

public class CustomRestException extends RuntimeException {
public CustomRestException(String msg){
    super(msg);
}
}
