package com.example.jsproducerloans.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.jsproducerloans.dao.BranchDao;
import com.example.jsproducerloans.entity.Branch;
import com.example.jsproducerloans.entity.LoansBus;
import com.example.jsproducerloans.dao.LoansBusDao;
import com.example.jsproducerloans.service.LoansBusService;
import com.example.jsproducerloans.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LoansBus)表服务实现类
 *
 * @author makejava
 * @since 2018-11-20 11:01:16
 */
@Service
public class LoansBusServiceImpl implements LoansBusService {
    @Resource
    private LoansBusDao loansBusDao;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private  BranchDao branchDao;
    /**
     * 通过ID查询单条数据
     *
     * @param loansBusid 主键
     * @return 实例对象
     */
    @Override
    public LoansBus queryById(Integer loansBusid) {
        return this.loansBusDao.queryById(loansBusid);
    }

    /**
     * 通过业务大类型查看所有小业务
     * @param typeid
     * @return
     */
    @Override
    public String getloanType(String typeid) {
        if(typeid != null && typeid != ""){
            if(redisUtil.hasKey("loanstype"+typeid)){
                List<LoansBus> o = (List<LoansBus>) redisUtil.get("loanstype" + typeid);
                return JSON.toJSONString(o);
            }else{
                List<LoansBus> loansBuses = loansBusDao.getbusByType(Integer.parseInt(typeid));
                redisUtil.set("loanstype"+typeid,loansBuses);
                return JSON.toJSONString(loansBuses);
            }
        }else {
            return "400"; //请求错误
        }
    }


    /**
     * 新增数据
     *
     * @param loansBus 实例对象
     * @return 实例对象
     */
    @Override
    public LoansBus insert(LoansBus loansBus) {
        this.loansBusDao.insert(loansBus);
        return loansBus;
    }

    @Override
    public String getBankInfo() {
        if(redisUtil.hasKey("bankinfo")){
            List<Branch>  branches = (List<Branch>) redisUtil.get("bankinfo");
            return JSON.toJSONString(branches);
        }else {
            List<Branch> all = branchDao.getAll();
            redisUtil.set("bankinfo",all);
            return JSON.toJSONString(all);
        }

    }

    /**
     * 修改数据
     *
     * @param loansBus 实例对象
     * @return 实例对象
     */
    @Override
    public LoansBus update(LoansBus loansBus) {
        this.loansBusDao.update(loansBus);
        return this.queryById(loansBus.getLoansBusid());
    }

    /**
     * 通过主键删除数据
     *
     * @param loansBusid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer loansBusid) {
        return this.loansBusDao.deleteById(loansBusid) > 0;
    }
}