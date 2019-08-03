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
import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/events")
public class EventController extends AbstractBaseController {

    @Autowired
    private EventServiceImpl eventService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventDTO> findEvents() {
        return this.eventService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event newEvent(@Valid @RequestBody Event newEvent) {
        findEmpByEmpId(newEvent.getEmpId());
        findCusByCusId(newEvent.getCusId());
        this.eventService.insertEventWage(newEvent);
        log.debug("new eventSeq {}", newEvent.getEventSeq());
        return newEvent;
    }

    @GetMapping("/emp/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventDTO> findByEmpId(@PathVariable @Min(1) Long id) {
        findEmpByEmpId(id);
        return this.eventService.findByEmpId(id)
                .orElseThrow(() -> new NotFoundException("Employee", id));
    }

    @GetMapping("/{seq}")
    @ResponseStatus(HttpStatus.OK)
    public EventDTO findBySeq(@PathVariable @Min(1) Long seq) {
        return findEveByEventSeq(seq);
    }

    @PutMapping("/{seq}")
    @ResponseStatus(HttpStatus.OK)
    public Event updateEvent(@PathVariable @Min(1) Long seq, @RequestBody Event event) {
        EventDTO oldEvent = this.findEveByEventSeq(seq);
        findEmpByEmpId(event.getEmpId());
        findCusByCusId(event.getCusId());
        event.setEventSeq(seq);
        if (oldEvent.getEmp().getEmpId() != event.getEmpId() || !oldEvent.getStartTime().equals(event.getStartTime())
                || !oldEvent.getEndTime().equals(event.getEndTime())) {
            this.eventService.updateEventWage(event);
        } else {
            this.eventService.update(event);
        }
        return event;
    }


    @DeleteMapping("/{seq}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable @Min(1) Long seq) {
        this.findEveByEventSeq(seq);
        this.eventService.delete(seq);
    }

    private EventDTO findEveByEventSeq(Long seq) {
        return this.eventService.findBySeq(seq)
                .orElseThrow(() -> new NotFoundException("Event", seq));
    }
}
