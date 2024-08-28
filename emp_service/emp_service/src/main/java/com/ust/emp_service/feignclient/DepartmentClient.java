package com.ust.emp_service.feignclient;
import com.ust.emp_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dept-service", url = "http://localhost:8080")
public interface DepartmentClient {

    @GetMapping("/api/v1/departments/{departmentId}")
    DepartmentDto getEmployeesByDepartment(@PathVariable int departmentId);
}
