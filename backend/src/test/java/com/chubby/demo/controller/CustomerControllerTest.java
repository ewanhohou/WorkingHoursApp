package com.chubby.demo.controller;

import com.chubby.demo.constant.ApiUrlConstant;
import com.chubby.demo.entity.Customer;
import com.chubby.demo.service.impl.CustomerServiceImpl;
import com.chubby.demo.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Slf4j
@WebMvcTest(CustomerController.class)
@Import(CustomerServiceImpl.class)
public class CustomerControllerTest extends AbstractControllerTest {

    private static final String URL = ApiUrlConstant.CUSTOMER_API;

    @MockBean
    private EmployeeServiceImpl empService;

    @Test
    public void testFindAll() throws Exception {
        Customer firstOne = mockFirstOne();
        testGet(URL)
                .andExpect(jsonPath("$[0].cusId", Matchers.equalTo((int) firstOne.getCusId())))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo(firstOne.getName())))
                .andExpect(jsonPath("$[0].mobile", Matchers.equalTo(firstOne.getMobile())))
                .andExpect(jsonPath("$[0].address", Matchers.equalTo(firstOne.getAddress())));
    }

    @Test
    public void testNewOne() throws Exception {
        Customer newOne = mockNewOne();
        testPost(URL, super.mapToJson(newOne))
                .andExpect(jsonPath("$.name", Matchers.equalTo(newOne.getName())))
                .andExpect(jsonPath("$.mobile", Matchers.equalTo(newOne.getMobile())))
                .andExpect(jsonPath("$.address", Matchers.equalTo(newOne.getAddress())));
    }

    @Test
    public void testFindById() throws Exception {
        Customer firstOne = mockFirstOne();
        testGet(URL + "/" + firstOne.getCusId(), super.mapToJson(firstOne));
    }

    @Test
    @Transactional
    public void testUpdate() throws Exception {
        Customer firstOne = mockFirstOne();
        Customer newOne = mockNewOne();
        newOne.setCusId(firstOne.getCusId());
        testPut(URL + "/" + firstOne.getCusId(), super.mapToJson(newOne));
    }

    @Test
    @Transactional
    public void testDelete() throws Exception {
        testDelete(URL + "/" + mockFirstOne().getCusId());
    }

    private Customer mockNewOne() {
        Customer cus = new Customer();
        cus.setName("Ginger");
        cus.setMobile("044444");
        cus.setAddress("NSW");
        return cus;
    }

    private Customer mockFirstOne() {
        Customer cus = new Customer();
        cus.setCusId(1);
        cus.setName("Tim");
        cus.setMobile("093132323");
        cus.setAddress("TAIWAN");
        return cus;
    }

}
