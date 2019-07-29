package com.chubby.demo.service.impl;

import com.chubby.demo.dao.EmployeeDao;
import com.chubby.demo.entity.Employee;
import com.chubby.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Optional<Employee> findById(long empId) {
        return Optional.ofNullable(employeeDao.findById(empId));
    }

    @Override
    public long insert(Employee employee) {
        return employeeDao.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(long empId) {
        employeeDao.delete(empId);
    }
}
