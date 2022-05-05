package com.CRUD.CRUD;


import org.springframework.beans.factory.annotation.Autowired;


public class EmployeService {

    @Autowired
    EmployeRepository employeeRepository;

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

}