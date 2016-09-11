package com.dev.sa.persistence.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.dev.sa.data.model.Employee;
import com.dev.sa.persistence.dao.impl.EmployeeDaoImpl;
/*import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;*/
import org.joda.time.LocalDate;
import org.junit.*;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Anie on 1/10/2016.
 */
public class EmployeeDaoTest extends AbstractTestPersistence {
    private   EmployeeDao employeeDao;

  /*  @BeforeClass
    public static void startServer() throws InterruptedException, TTransportException, ConfigurationException, IOException {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        Cluster cluster = new Cluster.Builder().addContactPoints("localhost").withPort(9042).build();
        Session session = cluster.connect();
        CQLDataLoader dataLoader = new CQLDataLoader(session);
        dataLoader.load(new ClassPathCQLDataSet("classpath:cql/create-tables.cql", true, "mykeyspace"));
    }*/


    @Before
    public void setupBefore() {

         employeeDao=(EmployeeDao)ctx.getBean(EmployeeDaoImpl.class);
    }


   /* @AfterClass
    public static void cleanupServer() {
        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
    }*/


    @Test
    public void createEmployeeTest()
    {
        try {
            Employee employee = new Employee(Math.abs(UUID.randomUUID().hashCode()), "sujit agarwal", 33, "214-729-0647",new Date());
            employeeDao.createEmployee(employee);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
   @Test
    public void testData()
    {
        System.out.println("helo worlds");
    }

}
