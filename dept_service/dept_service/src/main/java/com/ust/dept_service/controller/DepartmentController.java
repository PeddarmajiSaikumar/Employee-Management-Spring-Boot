package com.ust.dept_service.controller;
import com.ust.dept_service.dto.DepartmentDto;
import com.ust.dept_service.model.Department;
import com.ust.dept_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto dto){
        Department dept=new Department(dto.id(), dto.name(), dto.location());
        Department createdDepartment = departmentService.createDepartment(dept);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id){
        Department department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody Department department){
        Department updatedDepartment = departmentService.updateDepartment(id, department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable int id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
