package com.dev.sa.data.request;

import com.dev.sa.data.model.Employee;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.io.Serializable;

/**
 * Created by Anie on 7/16/2016.
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.WRAPPER_OBJECT,property="property")
@JsonSubTypes(@JsonSubTypes.Type(name="Employee",value =Employee.class))
public class ServicePayload implements Serializable {


}
