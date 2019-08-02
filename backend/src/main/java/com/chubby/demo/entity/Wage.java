package com.chubby.demo.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
public class Wage {

    private long wageSeq;
    @Min(value = 1, message = "Please provide correct empId")
    private long empId;
    @NotNull(message = "Please provide Start Time")
    private Timestamp startTime;
    @NotNull(message = "Please provide End Time")
    private Timestamp endTime;
    @Min(value = 0, message = "Please provide wage >0")
    private BigDecimal wage;
    @Min(value = 1, message = "Please provide correct empId")
    private long eventSeq;
    private BigDecimal workHour;
}
