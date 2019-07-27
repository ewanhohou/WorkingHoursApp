package com.chubby.demo.controller;

import com.chubby.demo.domain.Wage;
import com.chubby.demo.exception.NotFoundException;
import com.chubby.demo.service.impl.WageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/wages")
public class WageController {
    @Autowired
    private WageServiceImpl wageService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Wage> findWages() {
        return wageService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Wage newWage(@RequestBody Wage newWage) {
        wageService.insert(newWage);
        log.debug("new wageSeq {}", newWage.getWageSeq());
        return newWage;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Wage> findEmpById(@PathVariable Long id) {
        return wageService.findByEmpId(id)
                .orElseThrow(() -> new NotFoundException("Employee", id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Wage updateWage(@PathVariable("id") Long id, @RequestBody Wage wage) {
        wage.setWageSeq(id);
        wageService.update(wage);
        return wage;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWage(@PathVariable Long id) {
        wageService.delete(id);
    }


}
