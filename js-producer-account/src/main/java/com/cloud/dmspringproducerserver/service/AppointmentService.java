package com.cloud.dmspringproducerserver.service;

import com.cloud.dmspringproducerserver.entity.Appointment;
import java.util.List;

/**
 * (Appointment)表服务接口
 *
 * @author makejava
 * @since 2018-11-08 15:41:28
 */
public interface AppointmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param appointmentId 主键
     * @return 实例对象
     */
    Appointment queryById(Integer appointmentId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Appointment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    Appointment insert(Appointment appointment);

    /**
     * 修改数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    Appointment update(Appointment appointment);

    /**
     * 通过主键删除数据
     *
     * @param appointmentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer appointmentId);

}