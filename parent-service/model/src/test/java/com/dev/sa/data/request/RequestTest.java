package com.dev.sa.data.request;

import com.dev.sa.data.model.Employee;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 * Created by Anie on 1/11/2016.
 */
public class RequestTest {
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void TestRequest()
    {
    try {

        Employee employee = new Employee(123, "sujit agarwal", 33, "214-729-0647", new Date());
        String output = objectMapper.writeValueAsString(employee);
        com.dev.sa.data.request.ServicePayload request1=objectMapper.readValue(output, Employee.class);
        Employee e=(Employee)request1;
        Assert.assertEquals(employee.getAge(),e.getAge());
    }
    catch (Exception e)
    {
        Assert.fail();
    }

    }
    @Test
    public void TestListRequest()
    {
        try {
            objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            Employee employee = new Employee(125, "sujit agarwal", 33, "214-729-0647", new Date());
            Employee employee1 = new Employee(127, "sujit agarwal", 33, "214-729-0647", new Date());
            Employee employee3 = new Employee(123, "sujit agarwal", 33, "214-729-0647", new Date());
            Request request=new Request();
            List<Employee> list=new ArrayList();
            list.add(employee);
            list.add(employee1);
            list.add(employee3);
            request.setInfo(list);
            String output = objectMapper.writeValueAsString(request);
            System.out.println(output);
            com.dev.sa.data.request.Request request1=objectMapper.readValue(output, Request.class);

            //Assert.assertNotNull(request1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
           // Assert.fail();
        }

    }




}
