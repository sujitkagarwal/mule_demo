package com.dev.sa.persistence.dao.impl;

import com.dev.sa.common.exception.ServiceException;
import com.dev.sa.data.model.Employee;
import com.dev.sa.data.request.ServicePayload;
import com.dev.sa.persistence.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;


@Component
public class EmployeeDaoImpl implements EmployeeDao {

    public void setCassandraOperations(CassandraOperations cassandraOperations) {
        this.cassandraOperations = cassandraOperations;
    }

    @Autowired
    private CassandraOperations cassandraOperations;

    public void createEmployee(ServicePayload employee)throws ServiceException
    {
        try {
            cassandraOperations.insert((Employee) employee);
        }
        catch (Throwable exception)
        {
            throw new ServiceException("Fail to create employee ",exception);
        }
    }

}
