package com.chubby.demo.service;

import com.chubby.demo.domain.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();

    Optional<List<Event>> findByEmpId(long empId);

    long insert(Event event);

    void update(Event event);

    void delete(long eventSeq);
}
