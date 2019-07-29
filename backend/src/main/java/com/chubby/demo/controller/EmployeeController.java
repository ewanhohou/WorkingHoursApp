package com.chubby.demo.controller;

import com.chubby.demo.entity.Employee;
import com.chubby.demo.exception.NotFoundException;
import com.chubby.demo.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findEmployees() {
        return employeeService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee newEmployee(@Valid @RequestBody Employee newEmployee) {
        employeeService.insert(newEmployee);
        log.debug("new empId {}", newEmployee.getEmpId());
        return newEmployee;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findEmpById(@PathVariable Long id) {
        return employeeService.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee", id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employee.setEmpId(id);
        employeeService.update(employee);
        return employee;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }


}
