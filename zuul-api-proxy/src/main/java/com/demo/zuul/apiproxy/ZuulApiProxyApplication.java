package com.demo.zuul.apiproxy;

import com.demo.zuul.apiproxy.filters.ProxyFilter;
import com.demo.zuul.apiproxy.filters.StartPreFilter;
import com.demo.zuul.apiproxy.filters.StopPostFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApiProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApiProxyApplication.class, args);
    }

    @Bean
    public ProxyFilter proxyFilter() {
        return new ProxyFilter();
    }

    @Bean
    public StartPreFilter startPreFilter() {
        return new StartPreFilter();
    }

    @Bean
    public StopPostFilter stopPostFilter() {
        return new StopPostFilter();
    }
}
