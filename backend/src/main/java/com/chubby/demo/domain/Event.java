package com.chubby.demo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Event {

    private Long eventSeq;
    private Long empId;
    private Long cusId;
    private Date startTime;
    private Date endTime;

}
