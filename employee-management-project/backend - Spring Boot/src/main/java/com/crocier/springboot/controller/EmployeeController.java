package com.crocier.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crocier.springboot.exception.ResourceNotFoundException;
import com.crocier.springboot.model.Employee;
import com.crocier.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empRepo.save(employee);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = empRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not found with id:" + id));
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {

		Employee employee = empRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not found with id:" + id));

		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());

		Employee updatedEmployee = empRepo.save(employee);

		return ResponseEntity.ok(updatedEmployee);

	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {

		Employee employee = empRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not found with id:" + id));

		empRepo.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);

		return ResponseEntity.ok(response);

	}

}
