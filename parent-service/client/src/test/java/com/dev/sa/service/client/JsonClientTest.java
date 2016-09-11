package com.dev.sa.service.client;

import com.dev.sa.data.model.Employee;
import com.dev.sa.data.request.Request;
import com.dev.sa.data.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Anie on 1/1/2016.
 */
public class JsonClientTest {
    JsonClient jsonClient=null;
    @Before
    public void setup()
    {
         jsonClient = new JsonClient();
    }


     @Ignore
    public void execute()
    {
    try {
        Employee employee=new Employee((int) (Math.random()*100),"sujit agarwal",33,"214-729-0647",new Date());
        Request request=new Request();
        request.setRequestorId("Test");
        List<Employee> emplist=new ArrayList<>();
        emplist.add(employee);
        request.setInfo(emplist);
        Response res= jsonClient.execute("http://localhost:8080/service/services/execution/generic/perform", request);
        System.out.println("response::: "+res.getStatus());
        System.out.println("response::: "+res.getResponse());
    }
    catch (Exception e)
    {
        e.printStackTrace();

        Assert.fail();
    }
    }
}
