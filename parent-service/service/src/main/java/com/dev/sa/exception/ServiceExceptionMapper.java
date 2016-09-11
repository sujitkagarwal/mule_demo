package com.dev.sa.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by Anie on 1/1/2016.
 */
public class ServiceExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        System.out.println("ServiceExceptionMapper Request 111"+ exception.getMessage());
        return Response.serverError().entity(exception.getMessage()).build();
    }
}
