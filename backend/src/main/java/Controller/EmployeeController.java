package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Employee;
import Repository.EmployeeRepository;


@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getemployees(){

        return employeeRepository.findAll();
    }

    @PostMapping("/addemployees")
     public Employee setemployees(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
}
