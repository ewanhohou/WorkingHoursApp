package com.chubby.demo.controller;

import com.chubby.demo.dto.EventDTO;
import com.chubby.demo.entity.Event;
import com.chubby.demo.exception.NotFoundException;
import com.chubby.demo.service.impl.EventServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventServiceImpl eventService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventDTO> findEvents() {
        return eventService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event newEvent(@Valid @RequestBody Event newEvent) {
        eventService.insert(newEvent);
        log.debug("new eventSeq {}", newEvent.getEventSeq());
        return newEvent;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventDTO> findEmpById(@PathVariable Long id) {
        return eventService.findByEmpId(id)
                .orElseThrow(() -> new NotFoundException("Employee", id));
    }

    @PutMapping("/{seq}")
    @ResponseStatus(HttpStatus.OK)
    public Event updateEvent(@PathVariable("seq") Long seq, @RequestBody Event event) {
        event.setEventSeq(seq);
        eventService.update(event);
        return event;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
    }


}
