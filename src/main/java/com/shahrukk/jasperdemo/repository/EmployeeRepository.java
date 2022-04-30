package com.shahrukk.jasperdemo.repository;

import com.shahrukk.jasperdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
