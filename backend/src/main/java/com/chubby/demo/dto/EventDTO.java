package com.chubby.demo.dto;

import com.chubby.demo.entity.Customer;
import com.chubby.demo.entity.Employee;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class EventDTO {

    private long eventSeq;
    private Employee emp;
    private Customer cus;
    private Timestamp startTime;
    private Timestamp endTime;
}
