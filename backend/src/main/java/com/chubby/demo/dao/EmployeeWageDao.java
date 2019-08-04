package com.chubby.demo.dao;

import com.chubby.demo.dto.EmployeeWageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface EmployeeWageDao {

    @Select("SELECT w.emp_id, e.name, year(start_time) as year, month(start_time) as month, sum(work_hour) as total_hour, sum(wage) as total_wage FROM wage w left join employee e on w.emp_id = e.emp_id where month(start_time) = #{month} and year(start_time) = #{year} group by w.emp_id, month(start_time), year(start_time)")
    List<EmployeeWageDTO> findByMonth(int year, int month);
}
