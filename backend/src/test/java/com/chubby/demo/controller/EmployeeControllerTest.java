package com.chubby.demo.controller;

import com.chubby.demo.constant.ApiUrlConstant;
import com.chubby.demo.entity.Employee;
import com.chubby.demo.service.impl.CustomerServiceImpl;
import com.chubby.demo.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@Slf4j
@WebMvcTest(EmployeeController.class)
@Import(EmployeeServiceImpl.class)
public class EmployeeControllerTest extends AbstractControllerTest {

    private static final String URL = ApiUrlConstant.EMPLOYEE_API;

    @MockBean
    private CustomerServiceImpl cusService;

    @Test
    public void testFindAll() throws Exception {
        Employee firstOne = mockFirstOne();
        testGet(URL)
                .andExpect(jsonPath("$[0].empId", Matchers.equalTo((int) firstOne.getEmpId())))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo(firstOne.getName())))
                .andExpect(jsonPath("$[0].mobile", Matchers.equalTo(firstOne.getMobile())))
                .andExpect(jsonPath("$[0].address", Matchers.equalTo(firstOne.getAddress())))
                .andExpect(jsonPath("$[0].hourWage", Matchers.is(firstOne.getHourWage().intValue())));
    }

    @Test
    public void testNewOne() throws Exception {
        Employee newOne = mockNewOne();
        testPost(URL, super.mapToJson(newOne))
                .andExpect(jsonPath("$.name", Matchers.equalTo(newOne.getName())))
                .andExpect(jsonPath("$.mobile", Matchers.equalTo(newOne.getMobile())))
                .andExpect(jsonPath("$.address", Matchers.equalTo(newOne.getAddress())))
                .andExpect(jsonPath("$.hourWage", Matchers.is(newOne.getHourWage().intValue())));
    }

    @Test
    public void testFindById() throws Exception {
        Employee firstOne = mockFirstOne();
        testGet(URL + "/" + firstOne.getEmpId(), super.mapToJson(firstOne));
    }

    @Test
    @Transactional
    public void testUpdate() throws Exception {
        Employee firstOne = mockFirstOne();
        Employee newOne = mockNewOne();
        newOne.setEmpId(firstOne.getEmpId());
        testPut(URL + "/" + firstOne.getEmpId(), super.mapToJson(newOne));
    }

    @Test
    @Transactional
    public void testDelete() throws Exception {
        testDelete(URL + "/" + mockFirstOne().getEmpId());
    }

    private Employee mockNewOne() {
        Employee emp = new Employee();
        emp.setName("Ginger");
        emp.setMobile("044444");
        emp.setAddress("NSW");
        emp.setHourWage(new BigDecimal(35));
        return emp;
    }

    private Employee mockFirstOne() {
        Employee emp = new Employee();
        emp.setEmpId(1);
        emp.setName("Ewan");
        emp.setMobile("043233232");
        emp.setAddress("Sydney");
        emp.setHourWage(new BigDecimal(20));
        return emp;
    }
}
