package com.chubby.demo.service;

import com.chubby.demo.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(long empId);

    long insert(Employee employee);

    void update(Employee employee);

    void delete(long empId);
}
