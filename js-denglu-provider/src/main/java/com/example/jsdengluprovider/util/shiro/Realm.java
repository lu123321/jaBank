package com.example.jsdengluprovider.util.shiro;

import com.example.jsdengluprovider.pojo.BankCard;
import com.example.jsdengluprovider.service.BankLoginService;
;
import com.example.jsdengluprovider.util.JWT.CreatUtil;
import com.example.jsdengluprovider.util.redis.RedisUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


import javax.annotation.Resource;

public class Realm extends AuthorizingRealm {
    @Resource
    private BankLoginService bankLoginService;
    @Resource
    private RedisUtil redisUtil;

    private int userid;

//    @Override
//    public boolean supports(AuthenticationToken authenticationToken){
//        return authenticationToken instanceof JWTToken;
//    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行授权逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        BankCard bankCard = bankLoginService.usernameLogin(token.getUsername());
        BankCard bankCard1 = bankLoginService.cardLogin(token.getUsername());
        BankCard bankCard2 = bankLoginService.phoneLogin(token.getUsername());


        if (bankCard != null){
            Integer userid = bankCard.getUserid();
            this.userid = userid;
            Claims claims = Jwts.claims();
            claims.put("user",userid);
            String s = CreatUtil.generateJwt(claims);
            redisUtil.set(userid+"token",s,1800);
            return new SimpleAuthenticationInfo("",bankCard.getWebpwd(),"");
        }else if (bankCard1 != null){
            Integer userid = bankCard1.getUserid();
            this.userid = userid;
            Claims claims = Jwts.claims();
            claims.put("user",userid);
            String s = CreatUtil.generateJwt(claims);
            redisUtil.set(userid+"token",s,1800);
            return new SimpleAuthenticationInfo("",bankCard1.getWebpwd(),"");
        }else if (bankCard2!=null){
            Integer userid = bankCard2.getUserid();
            this.userid = userid;
            Claims claims = Jwts.claims();
            claims.put("user",userid);
            String s = CreatUtil.generateJwt(claims);
            redisUtil.set(userid+"token",s,1800);
            return new SimpleAuthenticationInfo("",bankCard2.getWebpwd(),"");
        }else {
            return null;
        }
    }
    public int getid(){
        return userid;
    }
}
