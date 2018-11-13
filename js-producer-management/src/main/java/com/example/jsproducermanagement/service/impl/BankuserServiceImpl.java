package com.example.jsproducermanagement.service.impl;

import com.example.jsproducermanagement.entity.Bankuser;
import com.example.jsproducermanagement.dao.BankuserDao;
import com.example.jsproducermanagement.service.BankuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Bankuser)表服务实现类
 *
 * @author makejava
 * @since 2018-11-12 21:14:23
 */
@Service("bankuserService")
public class BankuserServiceImpl implements BankuserService {
    @Resource
    private BankuserDao bankuserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public Bankuser queryById(Integer userid) {
        return this.bankuserDao.queryById(userid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Bankuser> queryAllByLimit(int offset, int limit) {
        return this.bankuserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bankuser 实例对象
     * @return 实例对象
     */
    @Override
    public Bankuser insert(Bankuser bankuser) {
//        if(bankuser.getName())


        this.bankuserDao.insert(bankuser);
        return bankuser;
    }

    /**
     * 修改数据
     *
     * @param bankuser 实例对象
     * @return 实例对象
     */
    @Override
    public Bankuser update(Bankuser bankuser) {
//        if(ban)
        this.bankuserDao.update(bankuser);
        return this.queryById(bankuser.getUserid());
    }

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userid) {
        return this.bankuserDao.deleteById(userid) > 0;
    }
}