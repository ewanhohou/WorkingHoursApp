package com.chubby.demo.dto;

import com.chubby.demo.entity.Employee;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class WageDTO {
    private long wageSeq;
    private Employee emp;
    private Timestamp startTime;
    private Timestamp endTime;
    private BigDecimal wage;
}
