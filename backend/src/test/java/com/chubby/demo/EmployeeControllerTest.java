package com.chubby.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Slf4j
//@RunWith(SpringRunner.class)
//@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {


    //    @Autowired
    private MockMvc mockMvc;


    //    @Test
    public void testFindEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/employees")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees<li>.empId").isNotEmpty());
    }
}
