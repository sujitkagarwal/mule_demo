package com.dev.sa.common.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;


/**
 * Created by Anie on 6/21/2016.
 */
@Configuration
@Profile("embeded")
public class EmbededDataSource extends AppConfig{



    public SessionFactory getSessionFactory(){
        //jdbc:hsqldb:mem:testdb
       EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
       EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:/hsql*//*.sql")
                //.addScript("classpath:/org/springframework/batch/core/schema-drop-hsqldb.sql")
                //.addScript("classpath:/org/springframework/batch/core/schema-hsqldb.sql")
                //.addScript("classpath:database/dbinit.sql");
        .build();
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(db);
        sessionFactory.setPackagesToScan(new String[] { "com.dev.sa.data.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());


        return sessionFactory.getObject();
    }


}
