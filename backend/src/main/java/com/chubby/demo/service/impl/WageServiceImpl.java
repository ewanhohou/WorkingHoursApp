package com.chubby.demo.service.impl;

import com.chubby.demo.dao.WageDao;
import com.chubby.demo.dto.WageDTO;
import com.chubby.demo.entity.Wage;
import com.chubby.demo.service.WageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WageServiceImpl implements WageService {

    @Autowired
    private WageDao wageDao;

    @Override
    public List<WageDTO> findAll() {
        return wageDao.findAll();
    }

    @Override
    public Optional<List<WageDTO>> findByEmpId(long empId) {
        return Optional.ofNullable(wageDao.findByEmpId(empId));
    }

    @Override
    public long insert(Wage wage) {
        return wageDao.insert(wage);
    }

    @Override
    public void update(Wage wage) {
        wageDao.update(wage);
    }

    @Override
    public void delete(long wageSeq) {
        wageDao.delete(wageSeq);
    }
}
