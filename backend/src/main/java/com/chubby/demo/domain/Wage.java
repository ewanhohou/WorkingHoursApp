package com.chubby.demo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Wage {

    private Long wageSeq;
    private Long empId;
    private Date startTime;
    private Date endTime;
    private Double wage;

}
