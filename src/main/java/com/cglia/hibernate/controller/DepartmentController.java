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
import com.cglia.hibernate.model.Department;
import com.cglia.hibernate.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}

	@PostMapping
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
	        Optional<Department> optionalDepartment = departmentService.updateDepartment(id, department);
	        return optionalDepartment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
	}
}

