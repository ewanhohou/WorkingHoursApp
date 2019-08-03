package com.chubby.demo.service.impl;

import com.chubby.demo.dao.EmployeeDao;
import com.chubby.demo.dao.EventDao;
import com.chubby.demo.dao.WageDao;
import com.chubby.demo.dto.EventDTO;
import com.chubby.demo.entity.Employee;
import com.chubby.demo.entity.Event;
import com.chubby.demo.entity.Wage;
import com.chubby.demo.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private WageDao wageDao;

    @Autowired
    private EmployeeDao employeeDao;

    //8:00 AM
    @Value("${com.chubby.start-work}")
    private int startWork = 8;
    //16:00 PM
    @Value("${com.chubby.end-work}")
    private int endWork = 16;
    //one day max 8 hour = 480 min
    @Value("${com.chubby.max-work-hour}")
    private int maxWorkHour = 8;

    @Override
    public List<EventDTO> findAll() {
        return eventDao.findAll();
    }

    @Override
    public Optional<List<EventDTO>> findByEmpId(long empId) {
        return Optional.ofNullable(eventDao.findByEmpId(empId));
    }

    @Override
    public Optional<EventDTO> findBySeq(long eventSeq) {
        return Optional.ofNullable(eventDao.findBySeq(eventSeq));
    }

    @Override
    public long insert(Event event) {
        return eventDao.insert(event);
    }

    @Override
    public void update(Event event) {
        eventDao.update(event);
    }

    @Override
    public void delete(long eventSeq) {
        eventDao.delete(eventSeq);
    }

    @Transactional
    @Override
    public long insertEventWage(Event event) {
        long eventSeq = eventDao.insert(event);
        Employee emp = employeeDao.findById(event.getEmpId());
        getWageList(event, emp.getHourWage()).forEach(wage -> {
            wageDao.insert(wage);
        });
        return eventSeq;
    }

    @Transactional
    @Override
    public void updateEventWage(Event event) {
        eventDao.update(event);
        wageDao.deleteByEventSeq(event.getEventSeq());
        Employee emp = employeeDao.findById(event.getEmpId());
        getWageList(event, emp.getHourWage()).forEach(wage -> {
            wageDao.insert(wage);
        });
    }

    private List<Wage> getWageList(Event event, BigDecimal hourWage) {
        List<Wage> wageList = new ArrayList<>();

        LocalDateTime startTime = event.getStartTime().toLocalDateTime();

        LocalDateTime endTime = event.getEndTime().toLocalDateTime();
        Duration duration = Duration.between(startTime, endTime);
        long diffDays = Math.abs(duration.toDays());

        Timestamp startWorkTime = Timestamp.valueOf(LocalDateTime.of(endTime.getYear(), endTime.getMonth(), endTime.getDayOfMonth(), startWork, 0, 0));
        Timestamp endWorkTime = Timestamp.valueOf(LocalDateTime.of(startTime.getYear(), startTime.getMonth(), startTime.getDayOfMonth(), endWork, 0, 0));
        //same day
        if (diffDays == 0) {
            wageList.add(createWage(event, event.getStartTime(), event.getEndTime(), hourWage));
        } else {
            //different day
            //first day
            wageList.add(createWage(event, event.getStartTime(), endWorkTime, hourWage));
            //middle day
            if (diffDays >= 2) {
                LocalDateTime midStartWorkTime = LocalDateTime.of(startTime.getYear(), startTime.getMonth(), startTime.getDayOfMonth(), startWork, 0, 0);
                LocalDateTime midEndWorkTime = LocalDateTime.of(startTime.getYear(), startTime.getMonth(), startTime.getDayOfMonth(), endWork, 0, 0);
                for (int i = 1; i < diffDays; i++) {
                    wageList.add(createWage(event, Timestamp.valueOf(midStartWorkTime.plusDays(i)), Timestamp.valueOf(midEndWorkTime.plusDays(i)), hourWage));
                }
            }
            //final day
            wageList.add(createWage(event, startWorkTime, event.getEndTime(), hourWage));
        }
        return wageList;
    }

    private Wage createWage(Event event, Timestamp startTime, Timestamp endTime, BigDecimal hourWage) {
        Wage wage = new Wage();
        wage.setEmpId(event.getEmpId());
        wage.setEventSeq(event.getEventSeq());
        wage.setStartTime(startTime);
        wage.setEndTime(endTime);
        Duration duration = Duration.between(startTime.toLocalDateTime(), endTime.toLocalDateTime());
        long diffMinutes = Math.abs(duration.toMinutes());
        BigDecimal workHour;
        if (diffMinutes > maxWorkHour * 60) {
            workHour = new BigDecimal(maxWorkHour);
        } else {
            workHour = new BigDecimal(diffMinutes).divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP);
        }
        wage.setWorkHour(workHour);
        log.debug("workHour:{}", workHour);
        BigDecimal totalWage = workHour.multiply(hourWage);
        wage.setWage(totalWage);
        log.debug("totalWage:{}", totalWage);
        return wage;
    }



}
