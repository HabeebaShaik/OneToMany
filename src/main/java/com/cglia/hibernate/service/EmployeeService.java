package com.cglia.hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.hibernate.model.Employee;
import com.cglia.hibernate.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	 public Optional<Employee> updateEmployee(Long id, Employee employee) {
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            employee.setId(id);
	            return Optional.of(employeeRepository.save(employee));
	        } else {
	            return Optional.empty();
	        }
	    }
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}

}

