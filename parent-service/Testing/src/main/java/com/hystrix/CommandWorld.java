package com.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by Anie on 6/19/2016.
 */
public class CommandWorld extends AbstractHystrixCommand<String> {

    private final String name;

    public CommandWorld(String name) {
        super("TEST",1000);
        this.name = name;
    }

    @Override
    protected String run() {
        System.out.println("in side run method");
        // a real example would do work like a network call here
        return "Hello " + name + "!";
    }
}