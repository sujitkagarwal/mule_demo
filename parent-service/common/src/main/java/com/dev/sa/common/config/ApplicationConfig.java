package com.dev.sa.common.config;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;


/**
 * Created by Anie on 6/21/2016.
 */
@Configuration
@Profile("!embeded")
class ApplicationConfig extends AppConfig {

    @Override
    SessionFactory getSessionFactory() {
        return null;
    }


}
