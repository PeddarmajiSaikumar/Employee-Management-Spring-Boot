package com.ust.emp_service.service;
import com.ust.emp_service.exceptions.EmployeeNotFoundException;
import com.ust.emp_service.model.Employee;
import com.ust.emp_service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }

    public Employee getEmployeeById(int id){
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        throw new EmployeeNotFoundException("Employee not found with id: "+id);
    }

//    public Employee updateEmployee(int id, Employee employee) throws EmployeeNotFoundException {
//        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
//        if(optionalEmployee.isPresent()){
//            Employee existingEmployee=optionalEmployee.get();
//            existingEmployee.setName(employee.getName());
//            existingEmployee.setDept_id(employee.getDept_id());
//            return employeeRepository.save(existingEmployee);
//        }
//        throw new EmployeeNotFoundException("Employee not found with id: "+id);
//    }

//    public void deleteEmployee(int id){
//        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
//        if (optionalEmployee.isPresent()){
//            employeeRepository.deleteById(id);
//        }
//        throw new EmployeeNotFoundException("Employee not found with id: "+id);
//    }
}
