package com.chubby.demo.dao;

import com.chubby.demo.dto.WageDTO;
import com.chubby.demo.entity.Wage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface WageDao {

    @Select("SELECT * FROM wage order by wage_seq desc")
    @Results(value = {
            @Result(property = "emp", column = "emp_id",
                    one = @One(select = "com.chubby.demo.dao.EmployeeDao.findById"))})
    List<WageDTO> findAll();

    @Select("SELECT * FROM wage WHERE emp_id = #{empId} order by wage_seq desc")
    @Results(value = {
            @Result(property = "emp", column = "emp_id",
                    one = @One(select = "com.chubby.demo.dao.EmployeeDao.findById"))})
    List<WageDTO> findByEmpId(long empId);

    @Select("SELECT * FROM wage WHERE wage_seq = #{wageSeq}")
    @Results(value = {
            @Result(property = "emp", column = "emp_id",
                    one = @One(select = "com.chubby.demo.dao.EmployeeDao.findById"))})
    WageDTO findBySeq(long wageSeq);

    @Insert("INSERT INTO wage (emp_Id, start_time, end_time, wage, event_seq, work_hour) VALUES(#{empId}, #{startTime}, #{endTime}, #{wage}, #{eventSeq}, #{workHour})")
    @Options(useGeneratedKeys = true, keyProperty = "wageSeq")
    long insert(Wage wage);

    @Update("UPDATE wage SET emp_Id=#{empId}, start_time=#{startTime}, end_time=#{endTime}, wage=#{wage}, work_hour=#{workHour} WHERE wage_seq =#{wageSeq}")
    void update(Wage wage);

    @Delete("DELETE FROM wage WHERE wage_seq =#{wageSeq}")
    void delete(long wageSeq);

    @Delete("DELETE FROM wage WHERE event_seq =#{eventSeq}")
    void deleteByEventSeq(long eventSeq);
}
