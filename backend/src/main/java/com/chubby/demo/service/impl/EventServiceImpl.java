package com.chubby.demo.service.impl;

import com.chubby.demo.dao.EventDao;
import com.chubby.demo.dto.EventDTO;
import com.chubby.demo.entity.Event;
import com.chubby.demo.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Override
    public List<EventDTO> findAll() {
        return eventDao.findAll();
    }

    @Override
    public Optional<List<EventDTO>> findByEmpId(long empId) {
        return Optional.ofNullable(eventDao.findByEmpId(empId));
    }

    @Override
    public long insert(Event event) {
        return eventDao.insert(event);
    }

    @Override
    public void update(Event event) {
        eventDao.update(event);
    }

    @Override
    public void delete(long eventSeq) {
        eventDao.delete(eventSeq);
    }
}
