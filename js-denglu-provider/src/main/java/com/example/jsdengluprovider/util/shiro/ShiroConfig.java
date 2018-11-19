package com.example.jsdengluprovider.util.shiro;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器，可以实现权限相关的拦截器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *      常用过滤器：
         *          anon：无需验证（登录）可以访问
         *          authc：必须认证才可以访问
         *          user：如果使用rememberMe的功能可以直接访问
         *          perms:该资源必须得到资源权限才可以访问
         *          role:该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String, String>();
        filterMap.put("/home","anon");
        //放行登录页面
        filterMap.put("/login","anon");
        filterMap.put("/yanzheng","anon");
        filterMap.put("/*","anon");
//        Map<String,Filter> filter = new HashMap<String, Filter>(1);
//        filter.put("jwt",new JWTFilter());
//        shiroFilterFactoryBean.setFilters(filter);
//        filterMap.put("/**","jwt");

        //修改跳转的登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    /**
     *
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("realm") Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Reaml
        securityManager.setRealm(realm);
//        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
//        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
//        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
//        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }
    /**
     * 创建Realm
     */
    @Bean(name = "realm")
    public Realm getRealm(){
        return new Realm();
    }
}
