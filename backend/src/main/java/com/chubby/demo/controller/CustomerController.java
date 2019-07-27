package com.chubby.demo.controller;

import com.chubby.demo.domain.Customer;
import com.chubby.demo.exception.NotFoundException;
import com.chubby.demo.service.impl.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findCustomers() {
        return customerService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        customerService.insert(newCustomer);
        log.debug("new cusId {}", newCustomer.getCusId());
        return newCustomer;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer findEmpById(@PathVariable Long id) {
        return customerService.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer", id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        customer.setCusId(id);
        customerService.update(customer);
        return customer;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }


}
