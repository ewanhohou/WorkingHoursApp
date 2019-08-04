package com.chubby.demo.controller;

import com.chubby.demo.constant.ApiUrlConstant;
import com.chubby.demo.service.impl.CustomerServiceImpl;
import com.chubby.demo.service.impl.EmployeeServiceImpl;
import com.chubby.demo.service.impl.EmployeeWageServiceImpl;
import com.chubby.demo.service.impl.WageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Slf4j
@WebMvcTest(WageController.class)
@Import({WageServiceImpl.class, EmployeeWageServiceImpl.class})
public class WageControllerTest extends AbstractControllerTest {

    private static final String URL = ApiUrlConstant.WAGE_API;

    @MockBean
    private EmployeeServiceImpl empService;

    @MockBean
    private CustomerServiceImpl cusService;

    @Test
    public void testFindByMonth() throws Exception {
        int year = 2019;
        int month = 7;
        testGet(URL + "/" + month + "/" + year)
                .andExpect(jsonPath("$[0].empId", notNullValue()))
                .andExpect(jsonPath("$[0].name", notNullValue()))
                .andExpect(jsonPath("$[0].year", is(year)))
                .andExpect(jsonPath("$[0].month", is(month)))
                .andExpect(jsonPath("$[0].totalHour", notNullValue()))
                .andExpect(jsonPath("$[0].totalWage", notNullValue()));
    }


}
