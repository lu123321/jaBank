package com.cloud.jsproducerremittance.service.impl;

import com.cloud.jsproducerremittance.dao.MakeremittanceDao;
import com.cloud.jsproducerremittance.entity.Makeremittance;
import com.cloud.jsproducerremittance.service.MakeremittanceService;
import com.cloud.jsproducerremittance.uitl.GetBank;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * (Makeremittance)表服务实现类
 *
 * @author makejava
 * @since 2018-11-22 20:51:09
 */
@Service
public class MakeremittanceServiceImpl implements MakeremittanceService {
    @Resource
    private MakeremittanceDao makeremittanceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param makeremittanceId 主键
     * @return 实例对象
     */
    @Override
    public Makeremittance queryById(Integer makeremittanceId) {
        return this.makeremittanceDao.queryById(makeremittanceId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Makeremittance> queryAllByLimit(int offset, int limit) {
        return this.makeremittanceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ma 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Makeremittance ma) {
        String maPrice = ma.getMakeremittancePrice();
        //判断输入的金额是否是int类型
        Pattern PATTERN = Pattern.compile("0|([-]?[1-9][0-9]*)");
        boolean intt = PATTERN.matcher(maPrice).matches();
        //判断输入的金额是否是double类型
        Pattern pattern = Pattern.compile("^[-\\+]?\\d+(\\.\\d*)?|\\.\\d+$");
        boolean doublee = pattern.matcher(maPrice).matches();
        if (!(intt || doublee)){
            return "请输入正确的金额!";
        }
        double v = Double.parseDouble(maPrice);
        if (v < 20000){
            return "预约汇款金额低于20000,不支持预约汇款!";
        }
        //生成预约编号
        String yyyyMMdd = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String now = System.currentTimeMillis() + "";
        int i=(int)(Math.random()*900)+100;
        ma.setMakeremittanceSerialnumber(Integer.parseInt(yyyyMMdd+now+i));
        //发起预约的当前时间
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ma.setMakeremittanceData(format.format(d));
        String enddate = "到行可立即汇款!";
        //根据预约款的多少，系统决定预约时间
        if (v >= 50000 && v < 70000){
            ca.add(Calendar.DATE, 1);
            d = ca.getTime();
            enddate = format.format(d);
        }else if (v >= 70000 && v < 100000){
            ca.add(Calendar.DATE, 2);
            d = ca.getTime();
            enddate = format.format(d);
        } else if ( v >= 100000 && v < 500000) {
            ca.add(Calendar.DATE, 5);
            d = ca.getTime();
            enddate = format.format(d);
        }else if (v >= 500000){
            ca.add(Calendar.DATE, 7);
            d = ca.getTime();
            enddate = format.format(d);
        }
        ma.setMakeremittanceTime(enddate);
        //判断是否是汉字  收款人姓名
        boolean hanzi = ma.getMakeremittanceName().matches("[\\u4e00-\\u9fa5]+");
        //判断是否是银行卡号 付款卡号 收款卡号
        boolean fukahao = GetBank.checkBankCard(ma.getMakeremittancePaynumber());
        boolean shoukahao = GetBank.checkBankCard(ma.getMakeremittanceNumber());

        if (!hanzi){
            return "请输入正确的姓名!";
        }
        if (!fukahao || !shoukahao){
            return "请输入正确的银行卡号!";
        }
        int insert = this.makeremittanceDao.insert(ma);
        if (insert > 0)
            return "200预约成功!";
        return "400预约失败!";
    }

    /**
     * 修改数据
     *
     * @param makeremittance 实例对象
     * @return 实例对象
     */
    @Override
    public Makeremittance update(Makeremittance makeremittance) {
        this.makeremittanceDao.update(makeremittance);
        return this.queryById(makeremittance.getMakeremittanceId());
    }

    /**
     * 通过主键删除数据
     *
     * @param makeremittanceId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer makeremittanceId) {
        return this.makeremittanceDao.deleteById(makeremittanceId) > 0;
    }
}