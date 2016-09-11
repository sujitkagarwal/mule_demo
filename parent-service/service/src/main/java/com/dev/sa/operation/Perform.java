package com.dev.sa.operation;

import com.dev.sa.data.request.Request;
import com.dev.sa.data.response.Response;
import org.springframework.stereotype.Component;

/**
 * Created by Anie on 12/27/2015.
 */

public interface Perform {

    public Response peformOpertaion(Request request)throws Exception;
}

