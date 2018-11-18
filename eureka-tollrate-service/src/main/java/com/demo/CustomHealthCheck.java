package com.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

    int errorCode = 0;

    @Override
    public Health health() {
        System.out.println("Error code " + errorCode);

        if(errorCode > 3 && errorCode < 6) {
            errorCode++;
            return Health.down().withDetail("Custom Error Code ", errorCode).build();
        }

        errorCode++;
        return Health.up().build();
    }
}
