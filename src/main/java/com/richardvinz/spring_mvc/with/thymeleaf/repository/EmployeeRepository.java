package com.richardvinz.spring_mvc.with.thymeleaf.repository;


import com.richardvinz.spring_mvc.with.thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
