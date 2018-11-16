package com.cloud.jsproduceraccount.service.impl;

import com.alibaba.fastjson.JSON;
import com.cloud.jsproduceraccount.entity.Branch;
import com.cloud.jsproduceraccount.dao.BranchDao;
import com.cloud.jsproduceraccount.service.BranchService;
import com.cloud.jsproduceraccount.service.pojo.BranchServicepojo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (Branch)表服务实现类
 *
 * @author makejava
 * @since 2018-11-12 10:41:38
 */
@Service
public class BranchServiceImpl implements BranchService {
    @Resource
    private BranchDao branchDao;

    /**
     * 通过ID查询单条数据
     *
     * @param branchId 主键
     * @return 实例对象
     * 根据网点ID查网点地址
     */
    @Override
    public String queryById(Integer branchId) {
        Branch branch = this.branchDao.queryById(branchId);
        BranchServicepojo branchServicepojo= new BranchServicepojo();
        branchServicepojo.setBranchSite(branch.getBranchSite());
        return JSON.toJSONString(branchServicepojo);
    }

    /**
     * 根据ID查询出网点信息
     * @param branchId
     * @return
     */
    @Override
    public String queryByallid(Integer branchId) {
        Branch branch = branchDao.queryByallid(branchId);
        return JSON.toJSONString(branch);
    }

    /**
     * 根据业务类型查询可办理银行
     * @param //branchBusinessone 预约人民币大额提现
     * @param //branchBusinesstwo 外币现金取款
     */
    @Override
    public String query(Integer branchBusinessone,Integer branchBusinesstwo) {
        List<Branch> query = branchDao.query(branchBusinessone, branchBusinesstwo);
        List<BranchServicepojo> querytwo = new ArrayList<BranchServicepojo>();
        for (Branch q:query) {
            BranchServicepojo branchService = new BranchServicepojo();
            branchService.setBranchId(q.getBranchId());
            branchService.setBranchName(q.getBranchName());
            querytwo.add(branchService);
        }
        return JSON.toJSONString(querytwo);
    }

    /**
     *
     * 根据星期几和网点ID查询网点受理业务时间段
     * @param branchId
     * @param time
     * @return
     */
    @Override
    public String queryIdAndTime(Integer branchId, String time) throws ParseException {

        String data;

        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(time));
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        int[] one = new int[]{1,3,5,7};

        if (Arrays.asList(one).contains(dayForWeek)){
            Branch branch = branchDao.queryByIdAndTime(branchId, 1, null);
            data = branch.getBranchData();
        }else {
            Branch branch = branchDao.queryByIdAndTime(branchId, null, 1);
            data = branch.getBranchDataTwo();
        }
        return data;
    }


    /**
     * 新增数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    @Override
    public Branch insert(Branch branch) {
        this.branchDao.insert(branch);
        return branch;
    }


    /**
     * 通过主键删除数据
     *
     * @param branchId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer branchId) {
        return this.branchDao.deleteById(branchId) > 0;
    }
}