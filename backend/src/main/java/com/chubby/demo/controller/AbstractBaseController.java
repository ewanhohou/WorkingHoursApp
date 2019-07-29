package com.chubby.demo.controller;

import com.chubby.demo.entity.Customer;
import com.chubby.demo.entity.Employee;
import com.chubby.demo.exception.NotFoundException;
import com.chubby.demo.service.impl.CustomerServiceImpl;
import com.chubby.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public abstract class AbstractBaseController {

    @Autowired
    protected EmployeeServiceImpl employeeService;

    @Autowired
    protected CustomerServiceImpl customerService;

    protected Employee findEmpByEmpId(Long id) {
        return this.employeeService.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee", id));
    }

    protected Customer findCusByCusId(Long id) {
        return this.customerService.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer", id));
    }

}
