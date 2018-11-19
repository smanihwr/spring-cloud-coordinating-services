package com.demo;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class FastpassClientRouting {

    @Autowired
    IClientConfig ribbonClientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig ribbonClientConfig) {
        return new WeightedResponseTimeRule();
    }

}
