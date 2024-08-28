package com.ust.dept_service.service;

import com.ust.dept_service.exceptions.DepartmentNotFoundException;
import com.ust.dept_service.model.Department;
import com.ust.dept_service.repository.Departmentpository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final Departmentpository departmentpository;

    public DepartmentService(Departmentpository departmentpository) {
        this.departmentpository = departmentpository;
    }


    public Department createDepartment(Department department) {
        departmentpository.save(department);
        return department;
    }


    public List<Department> getAllDepartments() {
        return departmentpository.findAll();
    }

    public Department getDepartmentById(int id) {
        Optional<Department> department = departmentpository.findById(id);
        if (department.isPresent()) {
            return department.get();
        } else {
            throw new DepartmentNotFoundException("Department not found with id: " + id);
        }
    }

    public Department updateDepartment(int id, Department department) {
        Optional<Department> existingDepartment = departmentpository.findById(id);
        if (existingDepartment.isPresent()) {
            Department updatedDepartment = existingDepartment.get();
            updatedDepartment.setName(department.getName());
            updatedDepartment.setLocation(department.getLocation());
            return departmentpository.save(updatedDepartment);
        } else {
            throw new DepartmentNotFoundException("Department not found with id: " + id);
        }
    }

    public void deleteDepartment(int id) {
        Optional<Department> existingDepartment = departmentpository.findById(id);
        if (existingDepartment.isPresent()) {
            departmentpository.deleteById(id);
        } else {
            throw new DepartmentNotFoundException("Department not found with id: " + id);
        }
    }
}
