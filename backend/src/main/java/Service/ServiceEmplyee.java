package Service;

import org.springframework.beans.factory.annotation.Autowired;

import Model.Employee;
import Repository.EmployeeRepository;



public class ServiceEmplyee {

    @Autowired
    EmployeeRepository employeeRepository;

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
  