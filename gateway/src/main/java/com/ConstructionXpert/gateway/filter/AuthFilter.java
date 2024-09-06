package com.ConstructionXpert.gateway.filter;

import com.ConstructionXpert.gateway.Client.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    @Autowired
    private AuthClient client;

    @Autowired
    private RouteValidator validator;

    public AuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (validator.isSecred.test(exchange.getRequest())) {
                //Header token ou pas
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Missing Auth Header");
                }
                String AuthHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (AuthHeader == null || !AuthHeader.startsWith("Bearer ")) {
                    throw new RuntimeException("Invalid Authorization Header Format");
                }

                String token = AuthHeader.substring(7);

                try {
                    // Validate the token by calling the auth-service
                    System.out.println("Token: " + token);
                    client.validateToken(token);
                } catch (Exception e) {
                    // Log and throw a specific exception for token validation failure
                    throw new RuntimeException("Invalid or Expired Token", e);
                }
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            }));
        };
    }


    public static class Config {
    }
}
