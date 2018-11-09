package com.cloud.jsconsumermanage.user.Impl;

import com.cloud.jsconsumermanage.feign.UserFeign;
import org.springframework.stereotype.Component;

@Component
public class UserFeignImpl implements UserFeign {
    //@Override
    public String login(String name) {
        return "错误" + name;
    }

    @Override
    public String login(int count) {
        return "错误" + count;
    }

    //@Override
    /*public String login() {
        return "垃圾网址，菜的一批";
    }*/
}
