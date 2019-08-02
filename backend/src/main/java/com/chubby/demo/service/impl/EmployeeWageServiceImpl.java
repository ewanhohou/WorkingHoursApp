package com.chubby.demo.service.impl;

import com.chubby.demo.dao.EmployeeWageDao;
import com.chubby.demo.dto.EmployeeWageDTO;
import com.chubby.demo.service.EmployeeWageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeWageServiceImpl implements EmployeeWageService {

    @Autowired
    private EmployeeWageDao employeeWageDao;

    @Override
    public Optional<List<EmployeeWageDTO>> findByMonth(int year, int month) {
        return Optional.ofNullable(employeeWageDao.findByMonth(year, month));
    }
}
