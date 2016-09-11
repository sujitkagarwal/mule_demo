package com.dev.sa.data.request;
import com.dev.sa.data.model.Employee;
import com.dev.sa.data.validation.NotNullElements;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.beans.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by Anie on 12/27/2015.
 */
/*
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.WRAPPER_OBJECT,property="property")
@JsonSubTypes(@JsonSubTypes.Type(name="Employee",value =Employee.class))
*/
public  class Request extends AbstractRequest{

    public List<? extends ServicePayload> getInfo() {
        return info;
    }
    public void setInfo(List<? extends ServicePayload> info) {
        this.info = info;
    }
    @NotNull(message ="ServicePayload object cannot be null")
    @Valid
    @NotNullElements(message ="ServicePayload object cannot be null")
    private List<?extends ServicePayload> info;

}
