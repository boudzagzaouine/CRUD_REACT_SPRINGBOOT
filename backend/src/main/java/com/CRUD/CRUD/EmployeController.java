package com.CRUD.CRUD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeController {

	@Autowired
	private EmployeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getemployees() {

		return employeeRepository.findAll();
	}

	@PostMapping("/employees")
	public Employee setemployees(@RequestBody Employee employee) {

		return employeeRepository.save(employee);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getemployebyid(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("there is no one with this id : " + id));
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> aupdateemployee(@PathVariable Long id, @RequestBody Employee employedetaills) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("there is no one with this id : " + id));
		employee.setFirstname(employedetaills.getFirstname());
		employee.setLastname(employedetaills.getLastname());
		employee.setEmail(employedetaills.getEmail());
		Employee apdatedemploye = employeeRepository.save(employee);
		return ResponseEntity.ok(apdatedemploye);
	}

	@DeleteMapping("/employees/{id}")
   public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("there is no one with this id : " + id));
		employeeRepository.delete(employee);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return  ResponseEntity.ok(response);
	}
}
