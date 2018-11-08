package com.cloud.dmspringproducerserver.controller;

import com.cloud.dmspringproducerserver.entity.Appointment;
import com.cloud.dmspringproducerserver.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Appointment)表控制层
 *
 * @author makejava
 * @since 2018-11-08 15:41:29
 */
@RestController
@RequestMapping("appointment")
public class AppointmentController {
    /**
     * 服务对象
     */
    @Resource
    private AppointmentService appointmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Appointment selectOne(Integer id) {
        return this.appointmentService.queryById(id);
    }

}