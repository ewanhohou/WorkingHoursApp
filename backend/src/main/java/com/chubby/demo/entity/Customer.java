package com.chubby.demo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class Customer {

    private long cusId;
    @NotBlank(message = "Please provide a name")
    private String name;
    @NotBlank(message = "Please provide a mobile number")
    private String mobile;
    @NotBlank(message = "Please provide an address")
    private String address;

}
