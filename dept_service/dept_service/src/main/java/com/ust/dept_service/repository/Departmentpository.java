package com.ust.dept_service.repository;

import com.ust.dept_service.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Departmentpository extends JpaRepository<Department,Integer> {
}
