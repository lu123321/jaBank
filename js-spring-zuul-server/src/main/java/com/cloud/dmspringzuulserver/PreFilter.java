package com.cloud.dmspringzuulserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component//组件化到spring
public class PreFilter extends ZuulFilter {

    /*@Value("${token}")
    private boolean token;*/

    @Override
    public String filterType() {
        //过滤器类型 PRE ROUTE POST  这三个过滤器再执行过程中都有可能进入ERROR过滤器
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;//同一过滤器的优先级 优先级再高也不会超过上一级过滤器  越小优先级越高，可以为负数。
    }

    @Override
    public boolean shouldFilter() {
        //是否开启当前过滤器  一般不直接指定true 或 false
        //一般使用
        //RequestContext ctx = RequestContext.getCurrentContext(); 这个对象是给过滤器传递信息的。
        //ctx.setSendZuulResponse(false);  设置布尔值
        //boolean b = ctx.sendZuulResponse();  获取布尔值
        //布尔值来判断
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();

        String token = request.getHeader("token");

        System.out.println(token);

        System.out.println("pass");

        return "pass";
    }
}
