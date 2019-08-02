package com.chubby.demo.service;

import com.chubby.demo.dto.EmployeeWageDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeWageService {

    Optional<List<EmployeeWageDTO>> findByMonth(int year, int month);

}
