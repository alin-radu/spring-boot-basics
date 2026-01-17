package com.dev.sprint_boot_rest_basics_2.repository;

import com.dev.sprint_boot_rest_basics_2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
