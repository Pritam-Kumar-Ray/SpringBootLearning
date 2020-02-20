package com.example.MyProject.service;

import com.example.MyProject.bean.Employee;
import com.example.MyProject.bean.EmployeeRequest;
import com.example.MyProject.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("emp2")
public class EmployeeService2 implements IEmployeeService {
    @Autowired
    private IEmployeeRepository repository;



//    @Override
//    public Employee createEmployee(EmployeeRequest request) {
//        Employee employee=new Employee(
//                UUID.randomUUID().toString(),
//                String.format("Mr. %s",request.getName()),
//                request.getSalary(),
//                request.getDesignation()
//        );
//        return employee;
//    }

    @Override
    public Employee createEmployee(EmployeeRequest request)
    {
        return repository.insert(request);
    }


    @Override
    public List<Employee> getEmployees()
    {
        return repository.all();
    }

    @Override
    public Employee getEmployeeById(String id) throws Exception {
        Optional<Employee> employee = repository.getById(id);
        if(employee.isPresent())
            return employee.get();
        throw new Exception(String.format("The employee with the id: %s is not present",id));

    }

    @Override
    public List<Employee> getEmployeeByName(String name)  {
        List<Employee> emp=new ArrayList<>();
        return repository.getByName(name);
//        if(employee.isPresent())
//            return employee.get();
//        throw new Exception(String.format("The employee with the name: %s is not present",name));

    }

    @Override
    public Employee updateEmployee(String id, EmployeeRequest request) throws Exception {
        Employee emp= repository.update(id,request);
        if(emp!=null)
            return emp;
        throw new Exception(String.format("The id: %s is not valid",id));
    }

    @Override
    public Boolean deleteEmployee(String id) throws Exception {
        if(repository.delete(id))
        {
            return true;
        }
        throw new Exception(String.format("The id is not present"));


    }

}
