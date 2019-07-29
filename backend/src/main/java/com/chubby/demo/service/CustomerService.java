package com.chubby.demo.service;

import com.chubby.demo.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();

    Optional<Customer> findById(long cusId);

    long insert(Customer customer);

    void update(Customer customer);

    void delete(long cusId);
}
