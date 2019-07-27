package com.chubby.demo.service.impl;

import com.chubby.demo.dao.CustomerDao;
import com.chubby.demo.domain.Customer;
import com.chubby.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Optional<Customer> findById(long cusId) {
        return Optional.of(customerDao.findById(cusId));
    }

    @Override
    public long insert(Customer customer) {
        return customerDao.insert(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(long cusId) {
        customerDao.delete(cusId);
    }
}
