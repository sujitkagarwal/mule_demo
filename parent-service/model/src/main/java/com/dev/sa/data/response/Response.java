package com.dev.sa.data.response;

/**
 * Created by Anie on 12/27/2015.
 */
public class Response {
    private String status;
    private Object response;

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
