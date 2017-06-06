/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.example.greeting.api;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;
import com.lightbend.lagom.javadsl.api.broker.kafka.KafkaProperties;
import org.pcollections.PSequence;

import static com.lightbend.lagom.javadsl.api.Service.*;

/**
 * The hello service interface.
 * <p>
 * This describes everything that Lagom needs to know about how to serve and
 * consume the GreetingService.
 */
public interface GreetingService extends Service {

    /**
     * Example: curl http://localhost:9000/api/hello/Alice
     */
    ServiceCall<NotUsed, String> hello(String id);

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("greeting").withCalls(
                pathCall("/api/hello/:id",  this::hello)
        ).withAutoAcl(true);
        // @formatter:on
    }
}
