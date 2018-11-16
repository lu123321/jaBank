package com.example.jsdengluprovider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsdengluprovider.dao.AddressMassageDao;
import com.example.jsdengluprovider.pojo.Address;
import com.example.jsdengluprovider.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMassageDao addressMassageDao;
    @Override
    public String addSelect(Integer userid) {
        return JSON.toJSONString(addressMassageDao.addSelect(userid));
    }

    @Override
    public String delAddress(Address address) {
        return JSON.toJSONString(addressMassageDao.delAddress(address));
    }

    @Override
    public String updateAddress(Address address) {
        return JSON.toJSONString(addressMassageDao.updateAddress(address));
    }

    @Override
    public String addAddress(Address address) {
        return JSON.toJSONString(addressMassageDao.addAddress(address));
    }
}
