package com.dev.sprint_boot_rest_basics_2.repository;

import com.dev.sprint_boot_rest_basics_2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Why does this work even though I commented out @Repository?
//Because Spring Data JPA automatically creates the repository bean for you.
//But Spring Data JPA works differently:
//- It registers repositories through a repository factory mechanism, not component scanning.
//During startup, Spring:
//- Scans for interfaces extending JpaRepository
//- Generates a proxy implementation dynamically
//- Registers that proxy as a Spring bean
//- Makes it injectable
//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
