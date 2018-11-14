package com.example.js_deposit_provider;

import com.example.js_deposit_provider.util.DateUtil;
import com.example.js_deposit_provider.util.OrderNumberUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsDepositProviderApplicationTests {

    @Test
    public void contextLoads() {
        Date date1 = DateUtil.SchangeD("2018-11-11");
        String nowDate = DateUtil.getNowDate();
        Date date = DateUtil.SchangeD(nowDate);
        boolean sameDate = DateUtil.isSameDate(date1, date);
        System.out.println(sameDate);

    }

}
