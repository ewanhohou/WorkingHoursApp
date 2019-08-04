package com.chubby.demo.controller;

import com.chubby.demo.constant.ApiUrlConstant;
import com.chubby.demo.entity.Event;
import com.chubby.demo.service.impl.CustomerServiceImpl;
import com.chubby.demo.service.impl.EmployeeServiceImpl;
import com.chubby.demo.service.impl.EventServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Slf4j
@WebMvcTest(EventController.class)
@Import({EventServiceImpl.class, CustomerServiceImpl.class, EmployeeServiceImpl.class})
public class EventControllerTest extends AbstractControllerTest {

    private static final String URL = ApiUrlConstant.EVENT_API;

    @Test
    public void testFindAll() throws Exception {
        testGet(URL)
                .andExpect(jsonPath("$[*].eventSeq", notNullValue()))
                .andExpect(jsonPath("$[*].emp.empId", notNullValue()))
                .andExpect(jsonPath("$[*].cus.cusId", notNullValue()))
                .andExpect(jsonPath("$[*].startTime", notNullValue()))
                .andExpect(jsonPath("$[*].endTime", notNullValue()));
    }

    @Test
    @Transactional
    public void testNewOne() throws Exception {
        Event newOne = mockNewOne();
        testPost(URL, super.mapToJson(newOne))
                .andExpect(jsonPath("$.empId", is((int) newOne.getEmpId())))
                .andExpect(jsonPath("$.cusId", is((int) newOne.getCusId())))
                .andExpect(jsonPath("$.startTime", notNullValue()))
                .andExpect(jsonPath("$.endTime", notNullValue()));
    }

    @Test
    public void testFindById() throws Exception {
        Event firstOne = mockFirstOne();
        testGet(URL + "/" + firstOne.getEventSeq())
                .andExpect(jsonPath("$.eventSeq", is((int) firstOne.getEventSeq())))
                .andExpect(jsonPath("$.emp.empId", is((int) firstOne.getEmpId())))
                .andExpect(jsonPath("$.cus.cusId", is((int) firstOne.getCusId())))
                .andExpect(jsonPath("$.startTime", notNullValue()))
                .andExpect(jsonPath("$.endTime", notNullValue()));
    }

    @Test
    @Transactional
    public void testUpdate() throws Exception {
        Event firstOne = mockFirstOne();
        Event newOne = mockNewOne();
        newOne.setEventSeq(firstOne.getEventSeq());
        testPut(URL + "/" + firstOne.getEventSeq(), super.mapToJson(newOne))
                .andExpect(jsonPath("$.eventSeq", is((int) newOne.getEventSeq())))
                .andExpect(jsonPath("$.empId", is((int) newOne.getEmpId())))
                .andExpect(jsonPath("$.cusId", is((int) newOne.getCusId())))
                .andExpect(jsonPath("$.startTime", notNullValue()))
                .andExpect(jsonPath("$.endTime", notNullValue()));
    }

    @Test
    @Transactional
    public void testDelete() throws Exception {
        testDelete(URL + "/" + mockFirstOne().getEventSeq());
    }

    private Event mockNewOne() {
        Event event = new Event();
        event.setEmpId(2);
        event.setCusId(2);
        event.setStartTime(Timestamp.valueOf("2019-07-24 08:00:00"));
        event.setEndTime(Timestamp.valueOf("2019-07-25 15:00:00"));
        return event;
    }

    private Event mockFirstOne() {
        Event event = new Event();
        event.setEventSeq(1);
        event.setEmpId(1);
        event.setCusId(1);
        event.setStartTime(Timestamp.valueOf("2019-07-22 08:00:00"));
        event.setEndTime(Timestamp.valueOf("2019-07-23 15:00:00"));
        return event;
    }
}
