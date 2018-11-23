package com.cloud.jsproducerremittance.service.impl;

import com.alibaba.fastjson.JSON;
import com.cloud.jsproducerremittance.entity.Batch;
import com.cloud.jsproducerremittance.dao.BatchDao;
import com.cloud.jsproducerremittance.entity.Remittancetransaction;
import com.cloud.jsproducerremittance.pojovalue.Batchvalue;
import com.cloud.jsproducerremittance.rabbitmqUitl.RabbitConfig;
import com.cloud.jsproducerremittance.service.BatchService;
import com.cloud.jsproducerremittance.uitl.ExcelUtil;
import com.cloud.jsproducerremittance.uitl.GetBank;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (Batch)表服务实现类
 *
 * @author makejava
 * @since 2018-11-10 08:51:40
 */
@Service
public class BatchServiceImpl implements BatchService {
    @Resource
    private BatchDao batchDao;
    @Resource
    private RabbitTemplate rabbitTemplate;
    /**
     * 通过ID查询单条数据
     *
     * @param batchId 主键
     * @return 实例对象
     */
    @Override
    public String queryById(Integer batchId) {
        return JSON.toJSONString(this.batchDao.queryById(batchId));
    }

    /**
     * 验证银行卡号是否符合
     * @param number
     * @return
     */
    @Override
    public String verifycard(String number) {
        boolean empty = number.isEmpty();
        if (empty)
            return "卡号不可为空!";
        boolean b = GetBank.checkBankCard(number);
        if (b)
            return "200";
        return "请输入正确银行卡号!";
    }

    /**
     * 根据卡号和时间段查询批量明细 分页
     * @param ba
     * @return
     */
    @Override
    public String queryAll(Batchvalue ba) {
        if (ba.getType() == 0){
            List<Batch> batches = batchDao.queryAll("",ba.getBatchNumber(), ba.getOneTime(), ba.getTwoTime());
            PageHelper.startPage(ba.getIndex(),ba.getPageSize());
            PageInfo<Batch> p = new PageInfo<>(batches);
            return JSON.toJSONString(p);
        }else{
            List<Batch> batches = batchDao.queryAll(ba.getBatchNumber(),"", ba.getOneTime(), ba.getTwoTime());
            PageHelper.startPage(ba.getIndex(),ba.getPageSize());
            PageInfo<Batch> p = new PageInfo<>(batches);
            return JSON.toJSONString(p);
        }
    }


    /**
     * 新增数据
     *  批量汇款
     * @param batch 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(String batch) {
        //反序列话成对象集合
        List<Batch> batches = JSON.parseArray(batch, Batch.class);
        int a = 0;
        //时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        for (Batch b:batches) {
            if ("".equals(b.getBatchPrice())){
                return "请输入转账金额!";
            }
        }
        //创Excel表格需要的两个集合
        List<Map<String, String>> result = new ArrayList<>();
        Map<String, String> map = new LinkedHashMap<>();
        for (Batch b:batches) {
            //当前交易时间
            b.setBatchTime(format);
            int aa = this.batchDao.insert(b);
            if (aa > 0){
                a += aa;
                String json = "[{\"one\":\"" + b.getBatchNumber() + "\"}" + ","
                        + "{\"two\":\"" + b.getBatchPaynumber() + "\"}" + ","
                        + "{\"three\":\"" + b.getBatchPrice() + "\"}]";
                try {
                    rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_BATCH, json);
//  txt文本信息
                    /*//fw 中的true和false是设置写入文本的数据是否覆盖原来的，不覆盖设置 false 追加在后面
                    FileWriter fw = new FileWriter("D://batch.txt", true);
                    //设置文本内容
                    StringBuilder sb = new StringBuilder();
                    sb.append("========================================\r\n");
                    sb.append("当前时间:"+format + "\r\n");
                    sb.append("收款人姓名:\r\t" + b.getBatchName() + "\r\n");
                    sb.append("收款卡号:\r\t" + b.getBatchNumber() + "\r\n");
                    sb.append("收款地区:\r\t" + b.getBatchSite() + "\r\n");
                    sb.append("汇款金额:\r\t" + b.getBatchPrice() + "\r\n");
                    sb.append("收款人通知电话:\r\t" + b.getBatchPhone() + "\r\n");
                    sb.append("付款人姓名:\r\t" + b.getBatchPayname() + "\r\n");
                    sb.append("付款卡号:\r\t" + b.getBatchPaynumber() + "\r\n");
                    */
                    //读取配置文件获取币种信息
                    InputStream in = BatchServiceImpl.class.getClassLoader().getResourceAsStream("currencytable.properties");
                    Properties pro = new Properties();
                    pro.load(in);
                    String property = pro.getProperty(b.getBatchCurrency() + "");
                    String currency = new String(property.getBytes("iso8859-1"), "GBK");
                    /*sb.append("币种:" + "\r\t" + currency + "\r\n");
                    sb.append("========================================\r\n");
                    String batchh = sb.toString();
                    fw.write(batchh);
                    fw.close();*/
// Excel表格

                    map.put("当前时间", format);
                    map.put("收款人姓名",b.getBatchName());
                    map.put("收款卡号", b.getBatchNumber());
                    map.put("收款地区",b.getBatchSite());
                    map.put("汇款金额", b.getBatchPrice());
                    map.put("收款人通知电话",b.getBatchPhone());
                    map.put("付款人姓名",b.getBatchPayname());
                    map.put("付款卡号", b.getBatchPaynumber());
                    map.put("币种",currency);
                    result.add(map);
                }catch (IOException e){
                    e.printStackTrace();
                    return b.getBatchNumber() + "生成纸质汇款单失效";
                }
            }
        }
        try {
            String fileName = batches.get(0).getBatchPaynumber() + ".xls";     // 定义文件名
            String headString = "批量汇款表";          // 定义表格标题
            String sheetName = "批量汇款";                  // 定义工作表表名
            String filePath = "E:\\test\\";             // 文件本地保存路径
            String[] thead = {"当前时间", "收款人姓名", "收款卡号", "收款地区", "汇款金额", "收款人通知电话", "付款人姓名", "付款卡号", "币种"};                    // 定义表头内容
            int[] sheetWidth = {7500, 4000, 7000, 8000, 5000, 5000, 5000, 7000, 5000};   // 定义每一列宽度

            HSSFWorkbook wb = new HSSFWorkbook();           // 创建Excel文档对象
            HSSFSheet sheet = wb.createSheet(sheetName);    // 创建工作表
            // ①创建表格标题
            ExcelUtil.createHeadTittle(wb, sheet, headString, result.get(0).size() - 1);
            // result.get(0).size() - 1为表格占用列数，从0开始
            // ②创建表头
            ExcelUtil.createThead(wb, sheet, thead, sheetWidth);
            // ③填入数据
            ExcelUtil.createTable(wb, sheet, result);
            FileOutputStream fos = new FileOutputStream(new File(filePath + fileName));
            // filePath,fileName是如上定义的文件保存路径及文件名
            wb.write(fos);
            fos.close();
            wb.close();
        }catch (IOException e){
            e.printStackTrace();
            return batches.get(0).getBatchPaynumber() + "生成纸质汇款单失败";
        }
        if (a == batches.size()){
            return "200汇款成功!";
        }
        return "400汇款失败!";
    }

    /**
     * 通过主键删除数据
     *
     * @param batchId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer batchId) {
        return this.batchDao.deleteById(batchId) > 0;
    }
}