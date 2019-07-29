package com.chubby.demo.dto;

import com.chubby.demo.entity.Employee;
import lombok.Data;

import java.util.Date;

@Data
public class WageDTO {
    private Long wageSeq;
    private Employee emp;
    private Date startTime;
    private Date endTime;
    private Double wage;
}
