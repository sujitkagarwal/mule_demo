package com.dev.sa.persistence.dao;



import com.dev.sa.common.exception.ServiceException;
import com.dev.sa.data.request.ServicePayload;


/**
 * Created by Anie on 1/10/2016.
 */
public interface EmployeeDao {
    public void createEmployee(ServicePayload employee)throws ServiceException;
}
