package com.chubby.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.chubby.demo")
@SpringBootApplication
public class WorkingHoursAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkingHoursAppApplication.class, args);
    }

}
