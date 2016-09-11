package com.dev.sa.operation.impl;



import com.dev.sa.data.request.ServicePayload;
import com.dev.sa.data.response.Response;
import com.dev.sa.persistence.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Anie on 12/27/2015.
 */
@Component
public class PerformImpl {
        @Autowired
      private EmployeeDao employeeDao;
    public Response peformOpertaion(ServicePayload request) throws Exception
    {   // System.out.println("PerformImpl Request--"+request.getTransactionId());
         employeeDao.createEmployee(request);
        Response res=new Response();
        res.setStatus("success");
        res.setResponse("Employee created successfully");
        return res;
    }
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


}
