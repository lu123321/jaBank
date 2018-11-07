package com.example.jsproducermanagement.service.impl;

import com.example.jsproducermanagement.dao.AmountDao;
import com.example.jsproducermanagement.service.AmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmountServiceImpl implements AmountService{
    @Autowired
    private AmountDao ad;

    @Override
    public int update(Double dan, Double ri, Integer id) {

        return 0;
    }
}
