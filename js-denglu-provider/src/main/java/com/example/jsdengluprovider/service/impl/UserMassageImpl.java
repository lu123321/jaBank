package com.example.jsdengluprovider.service.impl;

import com.example.jsdengluprovider.dao.UserMassageDao;
import com.example.jsdengluprovider.service.UserMassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMassageImpl implements UserMassageService {

    @Autowired
    private UserMassageDao umd;

    @Override
    public String selectIdcard(Integer userid) {
        return umd.selectIncard(userid);
    }
}
