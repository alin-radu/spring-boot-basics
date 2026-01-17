package com.dev.sprint_boot_rest_security_basics.service;

import com.dev.sprint_boot_rest_security_basics.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
