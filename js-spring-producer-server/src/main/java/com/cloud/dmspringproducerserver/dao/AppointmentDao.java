package com.cloud.dmspringproducerserver.dao;

import com.cloud.dmspringproducerserver.entity.Appointment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Appointment)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-08 15:41:27
 */
@Component
public interface AppointmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param appointmentId 主键
     * @return 实例对象
     */
    Appointment queryById(@Param("id") Integer appointmentId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Appointment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param appointment 实例对象
     * @return 对象列表
     */
    List<Appointment> queryAll(Appointment appointment);

    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 影响行数
     */
    int insert(Appointment appointment);

    /**
     * 修改数据
     *
     * @param appointment 实例对象
     * @return 影响行数
     */
    int update(Appointment appointment);

    /**
     * 通过主键删除数据
     *
     * @param appointmentId 主键
     * @return 影响行数
     */
    int deleteById(Integer appointmentId);

}