package com.chubby.demo.service;

import com.chubby.demo.domain.Wage;

import java.util.List;
import java.util.Optional;

public interface WageService {

    List<Wage> findAll();

    Optional<List<Wage>> findByEmpId(long empId);

    long insert(Wage wage);

    void update(Wage wage);

    void delete(long wageSeq);
}
