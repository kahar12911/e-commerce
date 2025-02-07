package com.flipkart.e_commerce.controller;

import com.flipkart.e_commerce.model.Department;
import com.flipkart.e_commerce.model.Employee;
import com.flipkart.e_commerce.repository.DepartmentRepository;
import com.flipkart.e_commerce.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employeesOfDept/{deptName}")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable String deptName){
        List<Employee> employees = employeeRepository.findEmployeeByDepartmentName(deptName);
        return employees;
    }





}
