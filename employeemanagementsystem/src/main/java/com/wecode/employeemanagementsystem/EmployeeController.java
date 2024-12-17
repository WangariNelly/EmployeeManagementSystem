package com.wecode.employeemanagementsystem;

import com.wecode.employeemanagementsystem.models.Employee;
import com.wecode.employeemanagementsystem.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) throws Throwable {
        Employee employee;
        employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Employee> createEmployee (@RequestBody Employee employee) {
      Employee newEmployee = employeeService.newEmployee(employee);
      return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> deleteEmployee (@PathVariable("id") Long id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }
}

