package com.cglia.hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.hibernate.model.Department;
import com.cglia.hibernate.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id).orElse(null);
	}

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	 public Optional<Department> updateDepartment(Long id, Department department) {
	        Optional<Department> optionalDepartment = departmentRepository.findById(id);
	        if (optionalDepartment.isPresent()) {
	            department.setId(id);
	            return Optional.of(departmentRepository.save(department));
	        } else {
	            return Optional.empty();
	        }
	    }
	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}

}
