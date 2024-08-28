package com.ust.emp_service.controller;
import com.ust.emp_service.dto.EmployeeDto;
import com.ust.emp_service.feignclient.DepartmentClient;
import com.ust.emp_service.model.Employee;
import com.ust.emp_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentClient departmentClient;

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

//    @GetMapping
//    public ResponseEntity<List<Employee>> getAllEmployees(){
//        return ResponseEntity.ok(employeeService.getAllEmployees());
//    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id){
        Employee emp=employeeService.getEmployeeById(id);
        EmployeeDto employeeDto=new EmployeeDto(
                emp.getId(),
                emp.getName(),
                departmentClient.getEmployeesByDepartment(emp.getDept_id())
        );
        return ResponseEntity.ok(employeeDto);
    }


//    @PutMapping("/employee/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
//        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
//    }
//
//    @DeleteMapping("/employee/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.ok("Employee deleted successfully");
//    }
}
