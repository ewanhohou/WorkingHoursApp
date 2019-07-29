package com.chubby.demo.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Event {

    private long eventSeq;
    @Min(value = 1, message = "Please provide correct empId")
    private long empId;
    @Min(value = 1, message = "Please provide correct cusId")
    private long cusId;
    @NotNull(message = "Please provide Start Time")
    private Date startTime;
    @NotNull(message = "Please provide End Time")
    private Date endTime;


}
