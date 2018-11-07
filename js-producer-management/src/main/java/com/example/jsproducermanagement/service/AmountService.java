package com.example.jsproducermanagement.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface AmountService {
    int update(@RequestParam("dan") Double dan, @RequestParam("ri") Double ri, Integer id);
}
