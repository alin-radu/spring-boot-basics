package com.dev.sprint_boot_rest_security_basics.repository;

import com.dev.sprint_boot_rest_security_basics.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
