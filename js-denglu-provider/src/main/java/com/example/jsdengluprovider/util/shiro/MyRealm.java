package com.example.jsdengluprovider.util.shiro;

import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.service.BankLoginService;
import com.example.jsdengluprovider.util.JWT.JWTToken;
import com.example.jsdengluprovider.util.JWT.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private BankLoginService bankLoginService;
    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JWTUtil.getUsername(principals.toString());
        String webpwd = JWTUtil.getWebpwd(principals.toString());
        String user = bankLoginService.usernameLogin(username,webpwd);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        String webpwd = JWTUtil.getWebpwd(token);
        if (username == null) {
            throw new AuthenticationException("token无效");
        }
        BankCard bankCard = new BankCard();
        String userBean = bankLoginService.usernameLogin(username,webpwd);
        if (userBean == null) {
            throw new AuthenticationException("用户不存在!");
        }

        if (!JWTUtil.verify(token, username, bankCard.getWebpwd())) {
            throw new AuthenticationException("用户名或密码错误");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }

}
