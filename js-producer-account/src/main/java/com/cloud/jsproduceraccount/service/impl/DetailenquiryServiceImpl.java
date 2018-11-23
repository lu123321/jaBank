package com.cloud.jsproduceraccount.service.impl;

import com.alibaba.fastjson.JSON;
import com.cloud.jsproduceraccount.entity.Detailenquiry;
import com.cloud.jsproduceraccount.dao.DetailenquiryDao;
import com.cloud.jsproduceraccount.service.DetailenquiryService;
import com.cloud.jsproduceraccount.service.pojo.AppointmentServicepojo;
import com.cloud.jsproduceraccount.service.pojovalue.Detailenreturn;
import com.cloud.jsproduceraccount.service.pojovalue.Detailenvalue;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * (Detailenquiry)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 08:50:36
 */
@Service
public class DetailenquiryServiceImpl implements DetailenquiryService {
    @Resource
    private DetailenquiryDao detailenquiryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param detailenquiryId 主键
     * @return 实例对象
     */
    @Override
    public String queryById(Integer detailenquiryId) {
        Detailenquiry x = this.detailenquiryDao.queryById(detailenquiryId);
        Detailenreturn detai = new Detailenreturn();
        detai.setDetailenquiryId(x.getDetailenquiryId());
        detai.setDetailenquiryNumber(x.getDetailenquiryNumber());
        detai.setDetailenquiryData(x.getDetailenquiryData());
        detai.setDetailenquiryPlace(x.getDetailenquiryPlace());
        detai.setDetailenquiryAbstract(x.getDetailenquiryAbstract());
        detai.setDetailenquiryCountries(x.getDetailenquiryCountries());
        detai.setDetailenquiryOtherinformation(x.getDetailenquiryOtherinformation());
        detai.setDetailenquiryPaper(x.getDetailenquiryPaper());
        detai.setDetailenquiryFundflow(x.getDetailenquiryFundflow() == 1? "支出":"流入");
        detai.setDetailenquiryBalance(x.getDetailenquiryBalance());
        if (x.getDetailenquiryFundflow() == 1){
            detai.setDetailenquiryMoney("<span style='color:red'>-" +x.getDetailenquiryMoney() + "</span>");
        }else {
            detai.setDetailenquiryMoney("<span style='color:green'>+" +x.getDetailenquiryMoney() + "</span>");
        }

        try {
            Integer integer = x.getDetailenquiryTransactioncurrency();
            InputStream in = DetailenquiryServiceImpl.class.getClassLoader().getResourceAsStream("currencytable.properties");
            Properties pro = new Properties();
            pro.load(in);
            String property = pro.getProperty(integer + "");
            String gbk = new String(property.getBytes("iso8859-1"), "GBK");
            detai.setDetailenquiryTransactioncurrency(gbk);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return JSON.toJSONString(detai);
    }

    /**
     * 根据卡号 时间 流出 支出情况 查询明细
     * @param
     * @param
     * @param
     * @return
     */
    @Override
    public String queryAll(Detailenvalue de) {
        List<Detailenquiry> det = detailenquiryDao.queryAll(de.getNumber(), de.getOnetime(), de.getTwotime(),de.getFundflow());
        List<Detailenreturn> deta = new ArrayList<>();
        for (Detailenquiry x:det) {
            Detailenreturn detai = new Detailenreturn();
            detai.setDetailenquiryId(x.getDetailenquiryId());
            detai.setDetailenquiryData(x.getDetailenquiryData());
            detai.setDetailenquiryAbstract(x.getDetailenquiryAbstract());
            detai.setDetailenquiryOtherinformation(x.getDetailenquiryOtherinformation());
            detai.setDetailenquiryFundflow(x.getDetailenquiryFundflow() == 1? "支出":"流入");
            detai.setDetailenquiryBalance(x.getDetailenquiryBalance());
            if (x.getDetailenquiryFundflow() == 1){
                detai.setDetailenquiryMoney("<span style='color:red'>-" +x.getDetailenquiryMoney() + "</span>");
            }else {
                detai.setDetailenquiryMoney("<span style='color:green'>+" +x.getDetailenquiryMoney() + "</span>");
            }

            try {
                Integer integer = x.getDetailenquiryTransactioncurrency();
                InputStream in = DetailenquiryServiceImpl.class.getClassLoader().getResourceAsStream("currencytable.properties");
                Properties pro = new Properties();
                pro.load(in);
                String property = pro.getProperty(integer + "");
                String gbk = new String(property.getBytes("iso8859-1"), "GBK");
                detai.setDetailenquiryTransactioncurrency(gbk);
            }catch (IOException e){
                e.printStackTrace();
                return null;
            }
            deta.add(detai);
        }
        //分页
        PageHelper.startPage(de.getIndex(),de.getPageSize());
        PageInfo<Detailenreturn> p = new PageInfo<>(deta);

        return JSON.toJSONString(p);
    }


    /**
     * 新增数据
     *
     * @param detailenquiry 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Detailenquiry detailenquiry) {
        int insert = this.detailenquiryDao.insert(detailenquiry);
        if (insert > 0){
            return "200";
        }
        return "500";
    }



    /**
     * 通过主键删除数据
     *
     * @param detailenquiryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer detailenquiryId) {
        return this.detailenquiryDao.deleteById(detailenquiryId) > 0;
    }
}