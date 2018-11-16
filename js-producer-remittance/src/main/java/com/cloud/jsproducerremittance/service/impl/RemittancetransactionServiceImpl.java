package com.cloud.jsproducerremittance.service.impl;

import com.alibaba.fastjson.JSON;
import com.cloud.jsproducerremittance.SMS.IndustrySMS;
import com.cloud.jsproducerremittance.entity.Remittancetransaction;
import com.cloud.jsproducerremittance.dao.RemittancetransactionDao;
import com.cloud.jsproducerremittance.rabbitmqUitl.RabbitConfig;
import com.cloud.jsproducerremittance.service.RemittancetransactionService;
import com.cloud.jsproducerremittance.service.valuepojo.Remittanvalue;
import com.cloud.jsproducerremittance.uitl.RedisUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * (Remittancetransaction)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 08:51:22
 */
@Service
public class RemittancetransactionServiceImpl implements RemittancetransactionService {
    @Resource
    private RemittancetransactionDao remittancetransactionDao;
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private RedisUtil redisUtil;
    /**
     * 通过ID查询单条数据
     *
     * @param remittancetransactionId 主键
     * @return 实例对象
     */
    @Override
    public Remittancetransaction queryById(Integer remittancetransactionId) {
        return this.remittancetransactionDao.queryById(remittancetransactionId);
    }



    /**
     * 新增数据
     *
     * @param remittancetransaction 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Remittancetransaction remittancetransaction) {

        if (remittancetransaction.getRemittancetransactionNumber().equals(remittancetransaction.getRemittancetransactionCardnumber())){
            return "收款卡号和付款卡号不能相同!";
        }
        //判断是否是汉字  收款人姓名
        boolean hanzi = remittancetransaction.getRemittancetransactionName().matches("[\\u4e00-\\u9fa5]+");
        //判断是否是银行卡号 收款卡号
        boolean kahao = remittancetransaction.getRemittancetransactionCardnumber().matches("^\\d{19}$");
        //判断输入的金额是否是int类型
        Pattern PATTERN = Pattern.compile("0|([-]?[1-9][0-9]*)");
        boolean intt = PATTERN.matcher(remittancetransaction.getRemittancetransactionPrice()).matches();
        //判断输入的金额是否是double类
        Pattern pattern = Pattern.compile("^[-\\+]?\\d+(\\.\\d*)?|\\.\\d+$");
        boolean doublee = pattern.matcher(remittancetransaction.getRemittancetransactionPrice()).matches();
        if (hanzi && kahao && (intt || doublee)){

            //汇款发起时间
            remittancetransaction.setRemittancetransactionCurrent(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            //发送验证码
            String execute = IndustrySMS.execute(remittancetransaction.getPhone());
            //设置短信验证码时间为5分钟失效
            redisUtil.set(remittancetransaction.getPhone(),execute,60*5);
            //将汇款信息放入到redis中
            redisUtil.set(remittancetransaction.getRemittancetransactionPayuserid() + "",remittancetransaction,60*5);
            return "200输入正确已发送验证码";
        }
        return "400请正确输入";
    }

    //汇款发送验证码  验证验证码 添加汇款交易表 和 发送MQ给瀚文
    public String SMSMQ(Remittanvalue remittanvalue) {
        //根据Userid将汇款信息从redis拿出来
        String o = (String) redisUtil.get(remittanvalue.getUserid());
        String au = (String) redisUtil.get(remittanvalue.getPhone());

        System.out.println(o);
        //反序列化成对象
        Remittancetransaction remittancetransaction = JSON.parseObject(o, Remittancetransaction.class);
        if (au.equals(remittanvalue.getAuth())) {
                //添加汇款加以表
            int insert = this.remittancetransactionDao.insert(remittancetransaction);
            if (insert > 0) {
                //调MQ发送汇款给瀚文
                String json = "[{\"one\":\"" + remittancetransaction.getRemittancetransactionCardnumber() + "\"}" + ","
                        + "{\"two\":\"" + remittancetransaction.getRemittancetransactionNumber() + "\"}" + ","
                        + "{\"three\":\"" + remittancetransaction.getRemittancetransactionPrice() + "\"}]";
                rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_REMITTANCE, json);
                return "汇款成功" + remittancetransaction.getRemittancetransactionPrice() + "元";
            }
            return "汇款失败";
            }
        return "验证码错误";
    }
    /**
     * 修改数据
     *
     * @param remittancetransaction 实例对象
     * @return 实例对象
     */
    @Override
    public Remittancetransaction update(Remittancetransaction remittancetransaction) {
        this.remittancetransactionDao.update(remittancetransaction);
        return this.queryById(remittancetransaction.getRemittancetransactionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param remittancetransactionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer remittancetransactionId) {
        return this.remittancetransactionDao.deleteById(remittancetransactionId) > 0;
    }
}