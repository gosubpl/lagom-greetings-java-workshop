/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.example.greeting.impl;

import akka.NotUsed;
import com.example.greeting.api.GreetingService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;

/**
 * Implementation of the GreetingService.
 */
public class GreetingServiceImpl implements GreetingService {

    @Override
    public ServiceCall<NotUsed, String> hello(String id) {
        return request -> {
            //TODO greet our guest with the name passed in
            return CompletableFuture.completedFuture("Change Me!! **hint**  -->ask the persistent entity to greet you");
        };
    }
}
