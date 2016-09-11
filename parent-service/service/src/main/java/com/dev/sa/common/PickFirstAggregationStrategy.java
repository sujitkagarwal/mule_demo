package com.dev.sa.common;


import org.mule.DefaultMuleEvent;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.routing.AggregationContext;
import org.mule.routing.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Anie on 7/3/2016.
 */
public class PickFirstAggregationStrategy implements AggregationStrategy {
    Logger log= LoggerFactory.getLogger(PickFirstAggregationStrategy.class);

    @Override
    public MuleEvent aggregate(AggregationContext aggregationContext) throws MuleException {

        List<MuleEvent> eventWithException= aggregationContext.collectEventsWithExceptions();
        List<MuleEvent> eventWithoutException=aggregationContext.collectEventsWithoutExceptions();
        if(!eventWithException.isEmpty()) {
            log.info("logging exception of individual path");
            throw new RuntimeException("exception occcur while executing the parallel processing");
        }
        return DefaultMuleEvent.copy(eventWithoutException.get(0));
    }
}
