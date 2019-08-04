package com.chubby.demo.controller;

import com.chubby.demo.constant.ApiUrlConstant;
import com.chubby.demo.entity.Employee;
import com.chubby.demo.service.impl.CustomerServiceImpl;
import com.chubby.demo.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
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
        testGet(URL)
                .andExpect(jsonPath("$[*].empId", is(notNullValue())))
                .andExpect(jsonPath("$[*].name", is(notNullValue())))
                .andExpect(jsonPath("$[*].mobile", is(notNullValue())))
                .andExpect(jsonPath("$[*].address", is(notNullValue())))
                .andExpect(jsonPath("$[*].hourWage", is(notNullValue())));

    }

    @Test
    @Transactional
    public void testNewOne() throws Exception {
        Employee newOne = mockNewOne();
        testPost(URL, super.mapToJson(newOne))
                .andExpect(jsonPath("$.name", is(newOne.getName())))
                .andExpect(jsonPath("$.mobile", is(newOne.getMobile())))
                .andExpect(jsonPath("$.address", is(newOne.getAddress())))
                .andExpect(jsonPath("$.hourWage", is(newOne.getHourWage().intValue())));
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
        testPut(URL + "/" + firstOne.getEmpId(), super.mapToJson(newOne), true);
    }

    @Test
    @Transactional
    public void testDelete() throws Exception {
        testDelete(URL + "/" + mockFirstOne().getEmpId());
    }

    private Employee mockNewOne() {
        Employee emp = new Employee();
        emp.setName("Ginger");
        emp.setMobile("0444441111");
        emp.setAddress("NSW");
        emp.setHourWage(new BigDecimal(35));
        return emp;
    }

    private Employee mockFirstOne() {
        Employee emp = new Employee();
        emp.setEmpId(1);
        emp.setName("Ewan");
        emp.setMobile("0432332321");
        emp.setAddress("Sydney");
        emp.setHourWage(new BigDecimal(20));
        return emp;
    }
}
