package com.cloud.dmspringproducerserver.service.impl;

import com.cloud.dmspringproducerserver.entity.Appointment;
import com.cloud.dmspringproducerserver.dao.AppointmentDao;
import com.cloud.dmspringproducerserver.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Appointment)表服务实现类
 *
 * @author makejava
 * @since 2018-11-08 15:41:28
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Resource
    private AppointmentDao appointmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param appointmentId 主键
     * @return 实例对象
     */
    @Override
    public Appointment queryById(Integer appointmentId) {
        return this.appointmentDao.queryById(appointmentId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Appointment> queryAllByLimit(int offset, int limit) {
        return this.appointmentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    @Override
    public Appointment insert(Appointment appointment) {
        this.appointmentDao.insert(appointment);
        return appointment;
    }

    /**
     * 修改数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    @Override
    public Appointment update(Appointment appointment) {
        this.appointmentDao.update(appointment);
        return this.queryById(appointment.getAppointmentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param appointmentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer appointmentId) {
        return this.appointmentDao.deleteById(appointmentId) > 0;
    }
}