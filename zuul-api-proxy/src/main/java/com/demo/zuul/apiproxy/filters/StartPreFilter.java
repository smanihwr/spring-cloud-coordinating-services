package com.demo.zuul.apiproxy.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.time.Instant;

public class StartPreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("Calling a StartPreFilter");
        RequestContext context = RequestContext.getCurrentContext();
        context.set("starttime", Instant.now());
        return null;
    }
}
