package com.example.MyProject.repository;

import com.example.MyProject.bean.Employee;
import com.example.MyProject.bean.EmployeeRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    List<Employee> employees=new ArrayList<>();

    @Override
    public Employee insert(EmployeeRequest request)
    {

        Employee employee=new Employee(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getSalary(),
                request.getDesignation()
        );
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> all()
    {
        return employees;
    }

    @Override
    public Optional<Employee> getById(String id) {
        return employees.stream().filter(
          employee->employee.getId().equals(id)
        ).findFirst();
    }


@Override
public List<Employee> getByName(String name) {
    return  employees.stream().filter(
            employee->employee.getName().contains(name)).collect(Collectors.toList());

}

    @Override
    public Employee update(String id, EmployeeRequest request) {
        Optional<Employee> optionalEmployee= employees.stream().filter
                (
                employee -> employee.getId().equals(id)
                ).findFirst();

        if(optionalEmployee.isPresent())
        {
            Employee emp=optionalEmployee.get();
            emp.setName(request.getName());
            emp.setSalary(request.getSalary());
            emp.setDesignation(request.getDesignation());
            return emp;

        }
        return null;
    }

    @Override
    public boolean delete(String id) {

      return employees.removeIf(employee -> employee.getId().equals(id));



    }


}
