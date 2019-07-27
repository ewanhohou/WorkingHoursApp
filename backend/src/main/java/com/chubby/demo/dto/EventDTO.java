package com.chubby.demo.dto;

import com.chubby.demo.domain.Customer;
import com.chubby.demo.domain.Employee;
import lombok.Data;

import java.util.Date;

@Data
public class EventDTO {

    private Long eventSeq;
    private Employee emp;
    private Customer cus;
    private Date startTime;
    private Date endTime;
}
