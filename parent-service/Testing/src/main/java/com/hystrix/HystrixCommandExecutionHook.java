package com.hystrix;

import com.netflix.hystrix.HystrixInvokable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Anie on 9/11/2016.
 */
public class HystrixCommandExecutionHook extends com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook{

    private final static Logger Log= LoggerFactory.getLogger(HystrixCommandExecutionHook.class);

    @Override
    public <T> Exception onRunError(HystrixInvokable<T> commandInstance, Exception e) {
        Log.warn("Hystrix command "+commandInstance +"   run method faile cause :"+e);
        return e;
    }
}
