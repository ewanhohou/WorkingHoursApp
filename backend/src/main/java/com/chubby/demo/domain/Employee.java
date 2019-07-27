package com.chubby.demo.domain;

import lombok.Data;


@Data
public class Employee {

    private long empId;
    private String name;
    private String mobile;
    private String address;
    private double hourWage;

}
