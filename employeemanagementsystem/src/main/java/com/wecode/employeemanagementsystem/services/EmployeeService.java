package com.wecode.employeemanagementsystem.services;

import com.wecode.employeemanagementsystem.exception.UserNotFoundException;
import com.wecode.employeemanagementsystem.models.Employee;
import com.wecode.employeemanagementsystem.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee newEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
    public Employee getEmployeeById(Long id) throws Throwable {
      return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(Long id) {
            employeeRepo.deleteEmployeeById(id);
    }
}
