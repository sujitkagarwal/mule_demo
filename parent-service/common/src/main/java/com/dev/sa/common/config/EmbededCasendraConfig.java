package com.dev.sa.common.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;

import javax.sql.DataSource;

/**
 * Created by Anie on 6/22/2016.
 */
@Configuration
@Profile("embededCasendra")
public class EmbededCasendraConfig extends AppConfig {
    @Override
    SessionFactory getSessionFactory() {
        return null;
    }


/*public Session getDataLoader()
{

}*/





}
