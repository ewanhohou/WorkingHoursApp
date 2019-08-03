package com.chubby.demo.controller;

import com.chubby.demo.constant.ApiUrlConstant;
import com.chubby.demo.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiUrlConstant.CUSTOMER_API)
public class CustomerController extends AbstractBaseController {


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findCustomers() {
        return customerService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer newCustomer(@Valid @RequestBody Customer newCustomer) {
        customerService.insert(newCustomer);
        log.debug("new cusId {}", newCustomer.getCusId());
        return newCustomer;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer findEmpById(@PathVariable @Min(1) Long id) {
        return findCusByCusId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@PathVariable @Min(1) Long id, @RequestBody Customer customer) {
        findCusByCusId(id);
        customer.setCusId(id);
        customerService.update(customer);
        return customer;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable @Min(1) Long id) {
        findCusByCusId(id);
        customerService.delete(id);
    }


}
