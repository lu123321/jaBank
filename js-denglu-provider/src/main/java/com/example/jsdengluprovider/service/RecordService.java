package com.example.jsdengluprovider.service;


import com.example.jsdengluprovider.pojo.Record;

import java.util.List;

public interface RecordService {

    void addRecord(Integer userid);

    String selectRecord(Integer userid);

    List<Record> selectAll(Integer userid);
}
