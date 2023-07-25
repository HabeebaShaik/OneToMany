package com.cglia.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cglia.hibernate.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
