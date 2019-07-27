package com.chubby.demo.service;

import com.chubby.demo.domain.Wage;
import com.chubby.demo.dto.WageDTO;

import java.util.List;
import java.util.Optional;

public interface WageService {

    List<WageDTO> findAll();

    Optional<List<WageDTO>> findByEmpId(long empId);

    long insert(Wage wage);

    void update(Wage wage);

    void delete(long wageSeq);
}
