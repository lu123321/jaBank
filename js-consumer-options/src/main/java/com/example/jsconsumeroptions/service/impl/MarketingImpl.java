package com.example.jsconsumeroptions.service.impl;

import com.example.jsconsumeroptions.service.MarketingService;
import com.example.jsproduceroptions.entity.MarketingManagement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarketingImpl implements MarketingService {


    @Override
    public String selectOne(Integer userId, Integer number) {
        return "页面访问有错，请重试";
    }

    @Override
    public String tianjia(Integer userid, String name, String marketing, String phone, Integer state) {
        return "添加失败，请重新添加";
    }

    @Override
    public List<MarketingManagement> selectAll(Integer id) {
        return null;
    }

    @Override
    public String deleteById(Integer userId, Integer number) {
        return "删除失败,请重试";
    }

    @Override
    public String update(MarketingManagement marketingManagement) {
        return "修改失败,请重试";
    }

}
