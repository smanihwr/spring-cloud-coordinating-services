package com.demo.zuul.apiproxy.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class StopPostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
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
        Instant stop = Instant.now();

        RequestContext context = RequestContext.getCurrentContext();
        Instant start = (Instant) context.get("starttime");

        long difference = ChronoUnit.MILLIS.between(start, stop);
        System.out.println("StopPostFilter - Request took " + difference + " milliseconds." );

        return null;
    }
}
