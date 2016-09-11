package com.dev.sa.data.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Anie on 7/16/2016.
 */
public abstract class AbstractRequest implements Serializable {

    @NotNull(message ="requestorId  cannot be null")
    @NotBlank(message ="requestorId  cannot be null")
    private String requestorId;

    public String getRequestorId() {
        return requestorId;
    }

    public void setRequestorId(String requestorId) {
        this.requestorId = requestorId;
    }

}
