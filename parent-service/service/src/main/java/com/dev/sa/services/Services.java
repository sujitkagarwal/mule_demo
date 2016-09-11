package com.dev.sa.services;

/**
 * Created by Anie on 12/27/2015.
 */
import com.dev.sa.data.request.Request;
import com.dev.sa.data.response.Response;
import com.dev.sa.operation.Perform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/generic")
@Component
public class Services {


    private Perform perform;

    public void setPerform(Perform perform) {
        this.perform = perform;
    }
    @POST
    @Path("/perform")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response perform(final Request req) throws Exception{
        ///System.out.println("in request"+(String)req.getTransactionId());
       // return Response.status(200).entity("Testing").build();
       return perform.peformOpertaion(req);
    }
    @GET
    @Path("/test")
    public javax.ws.rs.core.Response testing() {
        System.out.println("in service request");
        return javax.ws.rs.core.Response.status(200).entity("I am in service").build();
    }


}

