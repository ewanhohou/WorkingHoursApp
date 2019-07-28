package com.chubby.demo.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
public class Employee {

    private long empId;
    @NotBlank(message = "Please provide a name")
    private String name;
    @NotBlank(message = "Please provide a mobile number")
    private String mobile;
    @NotBlank(message = "Please provide an address")
    private String address;
    @Min(value = 0, message = "Please provide hourWage >0")
    private double hourWage;

}
