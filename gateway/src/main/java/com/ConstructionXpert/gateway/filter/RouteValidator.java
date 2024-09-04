package com.ConstructionXpert.gateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndPoint = List.of (
            "/Auth/login",
            "/Auth/register",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecred =
            request -> openApiEndPoint
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
