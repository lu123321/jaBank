package com.cloud.jsproduceraccount.service;

import com.cloud.jsproduceraccount.entity.Appointment;
import java.util.List;

/**
 * (Appointment)表服务接口
 *
 * @author makejava
 * @since 2018-11-10 08:49:50
 */
public interface AppointmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param //Userid 主键
     * @return 实例对象
     */
    String queryById(Integer UserId,String timeone,String tiometwo,Integer index,Integer pageSize);

    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    String insert(Appointment appointment);

    /**
     * 根据预约信息ID和用户ID查询详细信息
     * @param appId
     * @param Userid
     * @return
     */
    String sellAll(Integer appId, Integer Userid);

    /**
     * 修改数据
     *
     * @param appointmentId 实例对象ID
     * @return int
     */
    int update(Integer appointmentId,Integer appointmentUserid);

    /**
     * 通过主键删除数据
     *
     * @param appointmentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer appointmentId);

}