package com.cloud.jsproducerremittance.service.impl;

import com.alibaba.fastjson.JSON;
import com.cloud.jsproducerremittance.SMS.IndustrySMS;
import com.cloud.jsproducerremittance.entity.Remittancetransaction;
import com.cloud.jsproducerremittance.dao.RemittancetransactionDao;
import com.cloud.jsproducerremittance.pojovalue.Remittansel;
import com.cloud.jsproducerremittance.rabbitmqUitl.RabbitConfig;
import com.cloud.jsproducerremittance.service.RemittancetransactionService;
import com.cloud.jsproducerremittance.service.valuepojo.Remittanvalue;
import com.cloud.jsproducerremittance.uitl.GetBank;
import com.cloud.jsproducerremittance.uitl.RedisUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
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
        boolean kahao = GetBank.checkBankCard(remittancetransaction.getRemittancetransactionCardnumber());
        //判断输入的金额是否是int类型
        Pattern PATTERN = Pattern.compile("0|([-]?[1-9][0-9]*)");
        boolean intt = PATTERN.matcher(remittancetransaction.getRemittancetransactionPrice()).matches();
        //判断输入的金额是否是double类
        Pattern pattern = Pattern.compile("^[-\\+]?\\d+(\\.\\d*)?|\\.\\d+$");
        boolean doublee = pattern.matcher(remittancetransaction.getRemittancetransactionPrice()).matches();
        if (hanzi && kahao && (intt || doublee)){

            //汇款发起时间
            remittancetransaction.setRemittancetransactionCurrent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            //            //发送验证码
            //String execute = IndustrySMS.execute(remittancetransaction.getPhone());
            //设置短信验证码时间为5分钟失效
            redisUtil.hset("rem",remittancetransaction.getPhone(),"12345",60*5);
            //将汇款信息放入到redis中
            String string = JSON.toJSONString(remittancetransaction);
            redisUtil.hset("remit",remittancetransaction.getRemittancetransactionPayuserid() + "",string,60*5);
            return "200输入正确已发送验证码";
        }
        return "400请正确输入";
    }

    //汇款发送验证码  验证验证码 添加汇款交易表 和 发送MQ给瀚文
    public String SMSMQ(Remittanvalue remittanvalue) {
        //根据Userid将汇款信息从redis拿出来
        String o = (String) redisUtil.hget("remit",remittanvalue.getUserid());
        String au = (String) redisUtil.hget("rem",remittanvalue.getPhone());
        if (o == null || au == null){
            return "操作超时!请重新操作!";
        }
        redisUtil.hdel("remit",remittanvalue.getUserid());
        redisUtil.hdel("rem",remittanvalue.getPhone());
        //反序列化成对象
        Remittancetransaction re = JSON.parseObject(o, Remittancetransaction.class);
        if (au != null && au.equals(remittanvalue.getAuth())) {
                //添加汇款加以表
            int insert = this.remittancetransactionDao.insert(re);
                if (insert > 0) {
                    //调MQ发送汇款给瀚文
                    String json = "[{\"one\":\"" + re.getRemittancetransactionCardnumber() + "\"}" + ","
                            + "{\"two\":\"" + re.getRemittancetransactionNumber() + "\"}" + ","
                            + "{\"three\":\"" + re.getRemittancetransactionPrice() + "\"}]";
                    //生成汇款文件
                    try {
                        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_REMITTANCE, json);
                        //fw 中的true和false是设置写入文本的数据是否覆盖原来的，不覆盖设置 false 追加在后面
                        FileWriter fw = new FileWriter("D://remittan.txt",false);
                        //时间
                        Date date = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String format = simpleDateFormat.format(date);
                        //设置文本内容
                        StringBuilder sb = new StringBuilder();
                        sb.append("当前时间"+format + "\r\n");
                        sb.append("收款人姓名:\r\t" + re.getRemittancetransactionName() + "\r\n");
                        sb.append("收款卡号:\r\t" + re.getRemittancetransactionCardnumber() + "\r\n");
                        //获取配置文件 读取数据
                        InputStream in = RemittancetransactionServiceImpl.class.getClassLoader().getResourceAsStream("database.properties");
                        Properties pro = new Properties();
                        pro.load(in);
                        String property = pro.getProperty(re.getRemittancetransactionBlank() + "");
                        String gbk = new String(property.getBytes("iso8859-1"), "GBK");
                        sb.append("收款银行:" + gbk + "\r\n");
                        sb.append("汇款金额:" + re.getRemittancetransactionPrice() + "\r\n");
                        //
                        InputStream in1 = RemittancetransactionServiceImpl.class.getClassLoader().getResourceAsStream("time.properties");
                        pro.load(in1);
                        String property1 = pro.getProperty(re.getRemittancetransactionTime() + "");
                        String time = new String(property1.getBytes("iso8859-1"), "GBK");
                        sb.append("汇款时间:" + time + "\r\n");
                        sb.append("汇款时间:" + re.getRemittancetransactionCurrent() + "\r\n");
                        sb.append("付款卡号:" + re.getRemittancetransactionNumber() + "\r\n");
                        String a = sb.toString();
                        fw.write(a);
                        fw.close();
                    }catch (IOException e){
                        e.printStackTrace();
                        return "生成纸质汇款单失效";
                    }
                    return "汇款成功" + re.getRemittancetransactionPrice() + "元";
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
     * 查询单笔汇款明细
     * @param rem
     * @return
     */
    @Override
    public String selALL(Remittansel rem) {
        if (rem.getType() == 0){
            List<Remittancetransaction> remittancetransactions = this.remittancetransactionDao.queryAll("",rem.getCardnumber(), rem.getOnetime(), rem.getTwotime());
            System.out.println("000");
            System.out.println(JSON.toJSONString(remittancetransactions));
            return JSON.toJSONString(remittancetransactions);
        }
        List<Remittancetransaction> remittancetransactions = this.remittancetransactionDao.queryAll(rem.getCardnumber(), "", rem.getOnetime(), rem.getTwotime());
        return JSON.toJSONString(remittancetransactions);
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