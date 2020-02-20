package com.example.MyProject.repository;

import com.example.MyProject.bean.Employee;
import com.example.MyProject.bean.EmployeeRequest;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {
    Employee insert(EmployeeRequest request);

    List<Employee> all();

    Optional<Employee> getById(String id);
    List<Employee> getByName(String name);

    Employee update(String id, EmployeeRequest request);

    boolean delete(String id);
}
