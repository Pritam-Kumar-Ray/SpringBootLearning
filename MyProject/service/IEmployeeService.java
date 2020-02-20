package com.example.MyProject.service;

import com.example.MyProject.bean.Employee;
import com.example.MyProject.bean.EmployeeRequest;

import java.util.List;

public interface IEmployeeService {
    Employee createEmployee(EmployeeRequest request);

    List<Employee> getEmployees();

    List<Employee> getEmployeeByName(String name) throws Exception;
    Employee getEmployeeById(String id) throws Exception;

    Employee updateEmployee(String id, EmployeeRequest request) throws Exception;

    Boolean deleteEmployee(String id) throws Exception;

    //Employee getEmployees(String id);
}
