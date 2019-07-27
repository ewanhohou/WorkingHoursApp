package com.chubby.demo.domain;

import lombok.Data;


@Data
public class Customer {

    private long cusId;
    private String name;
    private String mobile;
    private String address;

}
