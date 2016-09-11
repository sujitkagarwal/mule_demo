package fixture.dao;

import com.dev.sa.common.exception.ServiceException;
import com.dev.sa.data.model.Employee;
import com.dev.sa.persistence.dao.EmployeeDao;
import com.dev.sa.persistence.dao.impl.EmployeeDaoImpl;
import fit.ColumnFixture;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

/**
 * Created by Anie on 7/3/2016.
 */
public class EmployeeDaoFixture extends ColumnFixture{

    public Integer empId;
    public Integer age;
    public String name;
    public String dob;


    public boolean getEmployee()
    {
       AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext("com.dev.sa");
       EmployeeDao employeeDao=(EmployeeDao)ctx.getBean(EmployeeDaoImpl.class);
       Employee employee=new Employee(empId,name,age,"214-729-0647",new Date(dob))  ;
        try {
            employeeDao.createEmployee(employee);
        } catch (ServiceException e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }
}
