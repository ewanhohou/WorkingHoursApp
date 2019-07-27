package com.chubby.demo.dao;

import com.chubby.demo.domain.Event;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface EventDao {

    @Select("SELECT * FROM event")
    List<Event> findAll();

    @Select("SELECT * FROM event WHERE emp_id = #{empId}")
    List<Event> findByEmpId(long empId);

    @Insert("INSERT INTO event (emp_Id, cus_Id, start_time, end_time) VALUES(#{empId}, #{cusId}, #{startTime}, #{endTime})")
    @Options(useGeneratedKeys = true, keyProperty = "eventSeq")
    long insert(Event event);

    @Update("UPDATE event SET start_time=#{startTime}, end_time=#{endTime} WHERE event_seq =#{eventSeq}")
    void update(Event event);

    @Delete("DELETE FROM event WHERE event_seq =#{eventSeq}")
    void delete(Long id);

}
