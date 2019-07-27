package com.chubby.demo.dao;

import com.chubby.demo.domain.Wage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface WageDao {

    @Select("SELECT * FROM wage")
    @Results(value = {
            @Result(property = "emp", column = "emp_id",
                    one = @One(select = "com.chubby.demo.dao.EmployeeDao.findById"))})
    List<Wage> findAll();

    @Select("SELECT * FROM wage WHERE emp_id = #{empId}")
    List<Wage> findByEmpId(long empId);

    @Insert("INSERT INTO wage (emp_Id, start_time, end_time, wage) VALUES(#{empId}, #{startTime}, #{endTime}, #{wage})")
    @Options(useGeneratedKeys = true, keyProperty = "wageSeq")
    long insert(Wage wage);

    @Update("UPDATE wage SET start_time=#{startTime}, end_time=#{endTime}, wage=#{wage} WHERE wage_seq =#{wageSeq}")
    void update(Wage wage);

    @Delete("DELETE FROM wage WHERE wage_seq =#{wageSeq}")
    void delete(Long id);

}
