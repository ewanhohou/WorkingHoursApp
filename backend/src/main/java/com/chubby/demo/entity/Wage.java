package com.chubby.demo.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Wage {

    private long wageSeq;
    @Min(value = 1, message = "Please provide correct empId")
    private long empId;
    @NotNull(message = "Please provide Start Time")
    private Date startTime;
    @NotNull(message = "Please provide End Time")
    private Date endTime;
    @Min(value = 0, message = "Please provide wage >0")
    private double wage;

}
