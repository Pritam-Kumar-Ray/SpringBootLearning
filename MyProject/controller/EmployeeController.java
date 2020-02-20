package com.example.MyProject.controller;

import com.example.MyProject.bean.Employee;
import com.example.MyProject.bean.EmployeeRequest;
import com.example.MyProject.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("v1")
public class EmployeeController {


    @Autowired
    @Qualifier("emp2")
    private IEmployeeService service;


    @PostMapping("employees")
    @ResponseStatus(HttpStatus.CREATED)
    Employee createEmployee(@RequestBody EmployeeRequest request)

    {
        return service.createEmployee(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("employees")
    public List<Employee> getAll()
    {
        return service.getEmployees();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="employees",params = {"id"})
    public Employee getEmployeeById(@RequestParam(value="id") String id) throws Exception {
        return service.getEmployeeById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="employees",params = {"name"})
    public List<Employee> getEmployeeByName(@RequestParam(value="name") String name) throws Exception
    {
        return service.getEmployeeByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("employees/{id}")
    public Employee update(@PathVariable("id") String id,@RequestBody EmployeeRequest request) throws Exception
    {
        return service.updateEmployee(id,request);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("employees/{id}")
    public String delete(@PathVariable String id) throws Exception {

        service.deleteEmployee(id);
        return String.format("Employee with id: %s successfully deleted.", id);

    }
}
