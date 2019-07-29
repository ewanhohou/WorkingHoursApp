package com.chubby.demo.controller;

import com.chubby.demo.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/employees")
public class EmployeeController extends AbstractBaseController {

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
    public Employee findEmpById(@PathVariable @Min(1) Long id) {
        return findEmpByEmpId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@PathVariable @Min(1) Long id, @RequestBody Employee employee) {
        findEmpByEmpId(id);
        employee.setEmpId(id);
        employeeService.update(employee);
        return employee;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable @Min(1) Long id) {
        findEmpByEmpId(id);
        employeeService.delete(id);
    }


}
