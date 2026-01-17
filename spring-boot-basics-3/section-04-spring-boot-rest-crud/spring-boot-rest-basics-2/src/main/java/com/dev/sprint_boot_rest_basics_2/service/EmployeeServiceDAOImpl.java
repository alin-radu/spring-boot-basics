package com.dev.sprint_boot_rest_basics_2.service;

import com.dev.sprint_boot_rest_basics_2.dao.EmployeeDAOImpl;
import com.dev.sprint_boot_rest_basics_2.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceDAOImpl implements EmployeeService {

    private final EmployeeDAOImpl employeeDAO;
    
    public EmployeeServiceDAOImpl(EmployeeDAOImpl employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}

