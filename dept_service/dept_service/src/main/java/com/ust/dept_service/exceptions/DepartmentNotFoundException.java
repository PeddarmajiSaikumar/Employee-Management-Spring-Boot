package com.ust.dept_service.exceptions;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String s) {
        super(s);
    }
}
