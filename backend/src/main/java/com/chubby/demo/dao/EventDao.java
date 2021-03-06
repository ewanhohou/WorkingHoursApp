package com.chubby.demo.dao;

import com.chubby.demo.dto.EventDTO;
import com.chubby.demo.entity.Event;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface EventDao {

    @Select("SELECT * FROM event order by event_seq desc")
    @Results(value = {
            @Result(property = "emp", column = "emp_id",
                    one = @One(select = "com.chubby.demo.dao.EmployeeDao.findById")),
            @Result(property = "cus", column = "cus_id",
                    one = @One(select = "com.chubby.demo.dao.CustomerDao.findById"))})
    List<EventDTO> findAll();

    @Select("SELECT * FROM event WHERE emp_id = #{empId} order by event_seq desc")
    @Results(value = {
            @Result(property = "emp", column = "emp_id",
                    one = @One(select = "com.chubby.demo.dao.EmployeeDao.findById")),
            @Result(property = "cus", column = "cus_id",
                    one = @One(select = "com.chubby.demo.dao.CustomerDao.findById"))})
    List<EventDTO> findByEmpId(long empId);

    @Select("SELECT * FROM event WHERE event_seq = #{eventSeq}")
    @Results(value = {
            @Result(property = "emp", column = "emp_id",
                    one = @One(select = "com.chubby.demo.dao.EmployeeDao.findById")),
            @Result(property = "cus", column = "cus_id",
                    one = @One(select = "com.chubby.demo.dao.CustomerDao.findById"))})
    EventDTO findBySeq(long eventSeq);

    @Insert("INSERT INTO event (emp_Id, cus_Id, start_time, end_time) VALUES(#{empId}, #{cusId}, #{startTime}, #{endTime})")
    @Options(useGeneratedKeys = true, keyProperty = "eventSeq")
    long insert(Event event);

    @Update("UPDATE event SET emp_Id=#{empId}, cus_Id=#{cusId}, start_time=#{startTime}, end_time=#{endTime} WHERE event_seq =#{eventSeq}")
    void update(Event event);

    @Delete("DELETE FROM event WHERE event_seq =#{eventSeq}")
    void delete(long eventSeq);

}
