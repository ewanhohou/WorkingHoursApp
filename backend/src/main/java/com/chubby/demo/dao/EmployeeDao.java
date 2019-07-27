package com.chubby.demo.dao;

import com.chubby.demo.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface EmployeeDao {

    @Select("SELECT * FROM employee")
    List<Employee> findAll();

    @Select("SELECT * FROM employee WHERE emp_id = #{empId}")
    Optional<Employee> findById(long empId);

    @Insert("INSERT INTO employee (name, mobile, address, hour_wage) VALUES(#{name}, #{mobile}, #{address}, #{hourWage})")
    @Options(useGeneratedKeys = true, keyProperty = "empId")
    long insert(Employee employee);

    @Update("UPDATE employee SET name=#{name}, mobile=#{mobile}, address=#{address}, hour_wage=#{hourWage} WHERE emp_id =#{empId}")
    void update(Employee employee);

    @Delete("DELETE FROM employee WHERE emp_id =#{empId}")
    void delete(Long id);

}