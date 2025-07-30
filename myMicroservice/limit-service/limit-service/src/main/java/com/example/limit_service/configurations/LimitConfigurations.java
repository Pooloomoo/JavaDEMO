package com.example.limit_service.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
public class LimitConfigurations {
    private long minimum;
    private long maximum;

    public long getMinimum() {
        return minimum;
    }

    public long getMaximum() {
        return maximum;
    }

    public void setMinimum(long minimum) {
        this.minimum = minimum;
    }

    public void setMaximum(long maximum) {
        this.maximum = maximum;
    }
}
