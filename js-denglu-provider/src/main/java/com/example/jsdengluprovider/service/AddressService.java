package com.example.jsdengluprovider.service;


import com.example.jsdengluprovider.pojo.Address;

public interface AddressService {
    String addSelect(Integer userid);

    String delAddress(Address address);

    String updateAddress(Address address);

    String addAddress(Address address);
}
