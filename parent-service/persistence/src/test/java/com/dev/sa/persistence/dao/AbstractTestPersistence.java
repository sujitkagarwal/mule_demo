package com.dev.sa.persistence.dao;

import com.dev.sa.common.config.AppConfig;
import com.dev.sa.common.config.CassandraConfig;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Anie on 1/10/2016.
 */

public class AbstractTestPersistence {
    public static AnnotationConfigApplicationContext ctx;
    @BeforeClass
    public static void setup()
    {
    ctx=new AnnotationConfigApplicationContext("com.dev.sa");
       /*// ctx.register(AppConfig.class);
         ctx.register(CassandraConfig.class);
        ctx.refresh();*/
    }

    @AfterClass
    public static void tearDown()
    {
        ((AnnotationConfigApplicationContext)ctx).close();
    }
}


