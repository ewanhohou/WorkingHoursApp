package com.chubby.demo.controller;

import com.chubby.demo.constant.ApiUrlConstant;
import com.chubby.demo.dto.EmployeeWageDTO;
import com.chubby.demo.dto.WageDTO;
import com.chubby.demo.entity.Wage;
import com.chubby.demo.exception.NotFoundException;
import com.chubby.demo.service.impl.EmployeeWageServiceImpl;
import com.chubby.demo.service.impl.WageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiUrlConstant.WAGE_API)
public class WageController extends AbstractBaseController {

    @Autowired
    private WageServiceImpl wageService;

    @Autowired
    private EmployeeWageServiceImpl employeeWageService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WageDTO> findWages() {
        return this.wageService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Wage newWage(@Valid @RequestBody Wage newWage) {
        findEmpByEmpId(newWage.getEmpId());
        this.wageService.insert(newWage);
        log.debug("new wageSeq {}", newWage.getWageSeq());
        return newWage;
    }

    @GetMapping("/emp/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<WageDTO> findByEmpId(@PathVariable @Min(1) Long id) {
        findEmpByEmpId(id);
        return this.wageService.findByEmpId(id)
                .orElseThrow(() -> new NotFoundException("Employee", id));
    }

    @GetMapping("/{year}/{month}")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeWageDTO> findByMonth(@PathVariable @Min(2000) int year, @PathVariable @Min(1) @Max(12) int month) {
        return this.employeeWageService.findByMonth(year, month)
                .orElseThrow(() -> new NotFoundException("employee wage"));
    }

    @GetMapping("/{seq}")
    @ResponseStatus(HttpStatus.OK)
    public WageDTO findBySeq(@PathVariable @Min(1) Long seq) {
        return findWagByWageSeq(seq);
    }

    @PutMapping("/{seq}")
    @ResponseStatus(HttpStatus.OK)
    public Wage updateWage(@PathVariable @Min(1) Long seq, @RequestBody Wage wage) {
        this.findWagByWageSeq(seq);
        findEmpByEmpId(wage.getEmpId());
        wage.setWageSeq(seq);
        this.wageService.update(wage);
        return wage;
    }


    @DeleteMapping("/{seq}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWage(@PathVariable @Min(1) Long seq) {
        this.findWagByWageSeq(seq);
        this.wageService.delete(seq);
    }

    private WageDTO findWagByWageSeq(Long seq) {
        return this.wageService.findBySeq(seq)
                .orElseThrow(() -> new NotFoundException("Wage", seq));
    }
}
