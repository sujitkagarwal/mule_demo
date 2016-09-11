package com.dev.sa.common.util;

import com.dev.sa.common.util.GenericValidator;
import com.dev.sa.data.request.Request;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Anie on 1/1/2016.
 */
public class GenericValidatorTest {
    GenericValidator<Request> validator = new GenericValidator<>();

    @Before
    public void setup() {


    }

    @Test
    public void ValidationTest() {
        try {
          /*  Request request = new Request();
            request.setRequest("Test");
            validator.validate(request);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}