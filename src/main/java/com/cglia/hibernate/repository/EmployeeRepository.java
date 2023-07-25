package com.cglia.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cglia.hibernate.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
