package com.dev.sa.data.model;



import com.dev.sa.data.request.ServicePayload;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;


/**
 * Created by Anie on 1/9/2016.
 */
@Table
public class Employee extends ServicePayload {

    @PrimaryKey
    private int empId;
    private String name;
    private int age;
    private String phone;
    private Date joiningDate;
    public Employee()
    {

    }

    public Employee(int empId, String name, int age, String phone, Date joiningDate) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.joiningDate = joiningDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }


    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", phone=" + phone + " ,joiningDate=" + joiningDate + " ]";
    }

}
