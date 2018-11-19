package com.demo.zuul.apiproxy.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ProxyFilter extends ZuulFilter {

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
        boolean isMobile = false;

        RequestContext context = RequestContext.getCurrentContext();
        String param = context.getRequest().getParameter("source");
        if(null != param && "mobile".equals(param)) {
            isMobile = true;
        }

        return isMobile;
    }

    @Override
    public Object run() {
        System.out.println("Calling a filter");
        return null;
    }
}
