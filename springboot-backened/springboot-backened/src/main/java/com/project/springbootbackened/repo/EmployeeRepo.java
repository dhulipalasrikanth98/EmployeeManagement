package com.project.springbootbackened.repo;

import com.project.springbootbackened.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
