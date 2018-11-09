package com.cloud.jsconsumermanage.user.Impl;

import com.cloud.jsconsumermanage.feign.UserFeign;
import com.cloud.jsconsumermanage.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserFeign userFeign;

    @Override
    public String login(int count) {
        return userFeign.login(count);
    }

   /* @Override
    public String login() {

        return userFeign.login();
    }*/
}
