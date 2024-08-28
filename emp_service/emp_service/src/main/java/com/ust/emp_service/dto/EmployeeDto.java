package com.ust.emp_service.dto;

public record EmployeeDto(
        int id,
        String name,
        DepartmentDto departmentDto
) {
}
