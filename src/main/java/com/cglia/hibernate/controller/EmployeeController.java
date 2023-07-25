package com.cglia.hibernate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.hibernate.model.Employee;
import com.cglia.hibernate.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	  @PutMapping("/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
	        Optional<Employee> optionalEmployee = employeeService.updateEmployee(id, employee);
	        return optionalEmployee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}
}