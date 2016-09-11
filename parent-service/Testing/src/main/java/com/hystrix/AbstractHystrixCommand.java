package com.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
 * Created by Anie on 6/19/2016.
 */
public abstract class AbstractHystrixCommand<T>  extends HystrixCommand<T> {

    public AbstractHystrixCommand(final String groupKey,int timeout)
    {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey)).
                andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(timeout)
                .withCircuitBreakerEnabled(false)
                .withMetricsRollingStatisticalWindowInMilliseconds(720000)
                .withMetricsRollingPercentileWindowInMilliseconds(720000))
        .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(1).withMaxQueueSize(40).withQueueSizeRejectionThreshold(200)));
    }

}
