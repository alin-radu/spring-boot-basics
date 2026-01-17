package com.dev.sprint_boot_rest_basics_2.dao;

import com.dev.sprint_boot_rest_basics_2.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
