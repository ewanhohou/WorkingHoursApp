package com.chubby.demo.dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class EmployeeWageDTO {
    private long empId;
    private String name;
    private int year;
    private int month;
    private BigDecimal totalWage;
}
