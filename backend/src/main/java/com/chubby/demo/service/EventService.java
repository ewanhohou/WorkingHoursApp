package com.chubby.demo.service;

import com.chubby.demo.dto.EventDTO;
import com.chubby.demo.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<EventDTO> findAll();

    Optional<List<EventDTO>> findByEmpId(long empId);

    Optional<EventDTO> findBySeq(long eventSeq);

    long insert(Event event);

    void update(Event event);

    void delete(long eventSeq);

    long insertEventWage(Event event);

    void updateEventWage(Event event);
}
