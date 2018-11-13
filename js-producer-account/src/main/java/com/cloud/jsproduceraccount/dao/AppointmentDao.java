package com.cloud.jsproduceraccount.dao;

import com.cloud.jsproduceraccount.entity.Appointment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Appointment)表数据库访问层
 *
 * @author makejava
 * @since 2018-11-10 08:49:49
 */
public interface AppointmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param UserId 主键
     * @return 实例对象
     */
    List<Appointment> queryById(@Param("UserId") Integer UserId,@Param("timeone") String timeone,@Param("timetwo") String timetwo);

    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 影响行数
     */
    int insert(Appointment appointment);

    /**
     * 根据预约信息ID和用户ID查询详细信息
     * @param appId
     * @param Userid
     * @return
     */
    Appointment selAll(@Param("appId") Integer appId,@Param("Userid") Integer Userid);

    /**
     * 修改数据
     * @param appointmentId 实例对象
     * @return
     */
    int update(Integer appointmentId);

























//                  上
    /**
     * 通过实体作为筛选条件查询
     *
     * @param appointment 实例对象
     * @return 对象列表
     */
    List<Appointment> queryAll(Appointment appointment);





    /**
     * 通过主键删除数据
     *
     * @param appointmentId 主键
     * @return 影响行数
     */
    int deleteById(Integer appointmentId);

}