package com.cloud.jsproduceraccount.service;

import com.cloud.jsproduceraccount.entity.Secondaccount;
import java.util.List;

/**
 * (Secondaccount)表服务接口
 *
 * @author makejava
 * @since 2018-11-10 08:50:53
 */
public interface SecondaccountService {

    /**
     * 判断密码是否一致，和是否是6位数的密码
     * @param pwdone
     * @param pwdtwo
     * @return
     */
    String Compare(String pwdone,String pwdtwo);
    /**
     * 通过ID查询单条数据
     *
     * @param accountUserid 主键
     * @return 实例对象
     */
    String queryById(Integer accountUserid);

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    String sendSMS(String phone);
    /**
     * 新增数据
     *
     * @param secondaccount 实例对象
     * @return 实例对象
     */
    String insert(Secondaccount secondaccount,String pwdone,String pwdtwo,String auth,String phone);

    /**
     * 修改数据
     *
     * @param
     * @return 实例对象
     */
    String update(String price,String paynumber,String accountCard);

    /**
     * 通过主键删除数据
     *
     * @param accountId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer accountId);

}