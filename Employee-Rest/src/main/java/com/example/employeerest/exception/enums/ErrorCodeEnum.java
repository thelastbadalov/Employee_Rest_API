package com.example.employeerest.exception.enums;

import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

public enum ErrorCodeEnum {
    EMPLOYEE_NOT_FOUND("can not find Employee with given id");

    ErrorCodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private final String message;

}
